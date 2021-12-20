package dev.fabula.android.measurements.lab.ui

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.print.PdfView
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import dev.fabula.android.R
import dev.fabula.android.app.ui.LayoutHeaderViewHolder
import dev.fabula.android.app.ui.ViewModelFragment
import dev.fabula.android.app.ui.event
import dev.fabula.android.bluetooth.GLMDeviceController
import dev.fabula.android.databinding.LabFragmentBinding
import dev.fabula.android.measurements.lab.adapter.LabMeasureAdapter
import dev.fabula.android.measurements.lab.adapter.SpinnerAdapter
import dev.fabula.android.measurements.lab.di.LabComponent
import dev.fabula.android.measurements.lab.model.SpinnerLabItem
import dev.fabula.android.measurements.receiver.MeasurementReceiver
import kotlinx.android.synthetic.main.report_fragment.*
import java.io.File


class LabFragment : ViewModelFragment<LabFragmentBinding>(R.layout.lab_fragment) {

    private var L1 = 0.0
    private var L2 = 0.0
    private var L0 = 0.0
    private var dh = 0.0
    private var a1 = 0.0
    private var a2 = 0.0

    private val viewModel: LabViewModel by activityViewModel()
    private lateinit var measurementReceiver: MeasurementReceiver
    private var alertDialogCalib: AlertDialog? = null
    private var CALIBRATION_FLAG = false
    private lateinit var adapterWidth: LabMeasureAdapter
    private lateinit var adapterHeight: LabMeasureAdapter

    private var measureHeight = arrayOf(
        SpinnerLabItem(1L, "200", mutableListOf()),
        SpinnerLabItem(2L, "300", mutableListOf()),
        SpinnerLabItem(3L, "400", mutableListOf()),
        SpinnerLabItem(4L, "500", mutableListOf()),
        SpinnerLabItem(5L, "600", mutableListOf())
    )

    private var measureWidth = arrayOf(
        SpinnerLabItem(1L, "1505", mutableListOf()),
        SpinnerLabItem(2L, "1530", mutableListOf()),
        SpinnerLabItem(3L, "1540", mutableListOf()),
        SpinnerLabItem(4L, "1550", mutableListOf()),
        SpinnerLabItem(5L, "1560", mutableListOf())
    )

    private lateinit var currentSpinnerItemHeight: SpinnerLabItem
    private lateinit var currentSpinnerItemWidth: SpinnerLabItem

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LabComponent.create(context)
            .inject(this)
    }

    override fun onDetach() {
        super.onDetach()
        measurementReceiver.destroyReceiver()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CALIBRATION_FLAG = false
        alertDialogCalib = AlertDialog.Builder(requireContext()).create()

        measurementReceiver = MeasurementReceiver(
            requireContext(),
            GLMDeviceController.ACTION_SYNC_CONTAINER_RECEIVED
        )

        adapterWidth = LabMeasureAdapter(resources.getString(R.string.width_))
        adapterHeight = LabMeasureAdapter(resources.getString(R.string.height_))

        adapterWidth.onItemClick = { index ->
            questionDeleteMeasure(index, 1)
        }

        adapterHeight.onItemClick = { index ->
            questionDeleteMeasure(index, 0)
        }

        binding = LabFragmentBinding.bind(view)
        binding!!.apply {
            recyclerViewWidth.adapter = adapterWidth
            recyclerViewHeight.adapter = adapterHeight

            btnCalibration.setOnClickListener {
                btnCalibration()
            }

            btnReport.setOnClickListener {
                report()
            }

            initTabLayout(this)
            initSpinnerHeight(this)
            initSpinnerWidth(this)

            webView.webViewClient = object : WebViewClient() {

                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    url: String
                ): Boolean {
                    return false
                }

                override fun onPageFinished(view: WebView, url: String) {
                }
            }

            LayoutHeaderViewHolder(layoutHeader, requireContext()).apply {

                hideLayoutImageProfile()

                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind("${resources.getString(R.string.lab)}")
        }

        measurementReceiver.initializeReceiver()

        measurementReceiver.boschMeasurement.event(viewLifecycleOwner) { boschMeasure ->

            if (CALIBRATION_FLAG) {

                val mc = measurementReceiver.calculateMeasure(boschMeasure)
                L1 = mc.L1
                a1 = mc.a1
                L0 = mc.L0
                dh = mc.dh

                CALIBRATION_FLAG = false

                Toast.makeText(requireContext(), "Устройство откалибровано", Toast.LENGTH_SHORT)
                    .show()

                alertDialogCalib?.hide()
            } else {

                boschMeasure.gipotinuza *= 1000.0
                L2 = boschMeasure.gipotinuza
                a2 = boschMeasure.ugol

                val littleMeasurement =
                    measurementReceiver.calculateMeasure(L0, L1, L2, a1, a2, requireContext(), dh)
                val L = littleMeasurement.L

                //height
                if (binding!!.tabLayout.selectedTabPosition == 0) {

                    if (currentSpinnerItemHeight.measureList.size == 5) {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.more_exist_measure),
                            Toast.LENGTH_SHORT
                        ).show()
                        return@event
                    }

                    currentSpinnerItemHeight.measureList.add(L.toString())
                    adapterHeight.submitList(currentSpinnerItemHeight.measureList)
                    adapterHeight.notifyDataSetChanged()


                } else {

                    if (currentSpinnerItemWidth.measureList.size == 5) {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.more_exist_measure),
                            Toast.LENGTH_SHORT
                        ).show()
                        return@event
                    }

                    currentSpinnerItemWidth.measureList.add(L.toString())
                    adapterWidth.submitList(currentSpinnerItemWidth.measureList)
                    adapterWidth.notifyDataSetChanged()
                }
            }
        }
    }

    private fun questionDeleteMeasure(index: Int, type: Int) {
        AlertDialog.Builder(requireContext())
            .setMessage(resources.getString(R.string.question_delete_item))
            .setPositiveButton(resources.getString(R.string.yes))
            { dialog, which ->
                if (type == 0) {
                    currentSpinnerItemHeight.measureList.removeAt(index)
                    adapterHeight.submitList(currentSpinnerItemHeight.measureList)
                    adapterHeight.notifyDataSetChanged()

                } else if (type == 1) {
                    currentSpinnerItemWidth.measureList.removeAt(index)
                    adapterWidth.submitList(currentSpinnerItemWidth.measureList)
                    adapterWidth.notifyDataSetChanged()
                }
            }
            .setNegativeButton(resources.getString(R.string.no)) { _, _ -> }
            .setCancelable(false)
            .create().show()
    }

    private fun btnCalibration() {
        val _view: View = layoutInflater.inflate(R.layout.calibration_dialog, null)
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle(resources.getString(R.string.calibration_values))
        alertDialog.setCancelable(false)
        alertDialog.setView(_view)

        val _width = _view.findViewById<View>(R.id.length) as TextView
        val _height = _view.findViewById<View>(R.id.height) as TextView
        val _angle = _view.findViewById<View>(R.id.angle) as TextView

        _width.text = L0.toString()
        _height.text = dh.toString()
        _angle.text = a1.toString()


        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE,
            resources.getString(R.string.action_close)
        ) { _, _ ->

        }

        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE,
            resources.getString(R.string.make_calibration)
        ) { _, _ ->
            waitCalibrationMeasurement()
        }

        alertDialog.show()
    }

    private fun waitCalibrationMeasurement() {
        CALIBRATION_FLAG = true
        alertDialogCalib!!.setTitle(resources.getString(R.string.calibration))
        alertDialogCalib!!.setCancelable(false)
        alertDialogCalib!!.setMessage(resources.getString(R.string.take_measurement))
        alertDialogCalib!!.setButton(
            AlertDialog.BUTTON_POSITIVE,
            resources.getString(R.string.action_cancel)
        ) { _, _ -> CALIBRATION_FLAG = false }

        alertDialogCalib!!.show()
    }

    private fun initTabLayout(binding: LabFragmentBinding) {
        binding.apply {
            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tabLayout.selectedTabPosition) {
                        0 -> {
                            widthContainer.visibility = View.GONE
                            heightContainer.visibility = View.VISIBLE
                        }
                        1 -> {
                            widthContainer.visibility = View.VISIBLE
                            heightContainer.visibility = View.GONE
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
            tabLayout.getTabAt(1)!!.select()
            tabLayout.getTabAt(0)!!.select()
        }
    }

    private fun initSpinnerWidth(binding: LabFragmentBinding) {

        currentSpinnerItemWidth = measureWidth[0]
        binding.spinnerWidth.adapter = SpinnerAdapter(requireContext(), measureWidth)

        binding.spinnerWidth.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {
                currentSpinnerItemWidth = measureWidth[position]
                adapterWidth.submitList(currentSpinnerItemWidth.measureList)
                adapterWidth.notifyDataSetChanged()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                // TODO Auto-generated method stub
            }
        }
    }

    private fun initSpinnerHeight(binding: LabFragmentBinding) {

        currentSpinnerItemHeight = measureHeight[0]
        binding.spinnerHeight.adapter = SpinnerAdapter(requireContext(), measureHeight)

        binding.spinnerHeight.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {
                currentSpinnerItemHeight = measureHeight[position]
                adapterHeight.submitList(currentSpinnerItemHeight.measureList)
                adapterHeight.notifyDataSetChanged()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                // TODO Auto-generated method stub
            }
        }
    }

    private fun report() {

        var flag = true
        measureWidth.forEach {
            if (it.measureList.size < 5) {
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.you_make_not_all_measure),
                    Toast.LENGTH_SHORT
                ).show()
                flag = false
                return@forEach
            }
        }

        measureHeight.forEach {
            if (it.measureList.size < 5) {
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.you_make_not_all_measure),
                    Toast.LENGTH_SHORT
                ).show()
                flag = false
                return@forEach
            }
        }
        if (!flag) return


        webView.loadDataWithBaseURL(
            null,
            getTextHtml(measureWidth.toList(), measureHeight.toList()),
            "text/HTML",
            "UTF-8",
            null
        )

        webView.webViewClient = object : WebViewClient() {
            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                webView()
            }
        }
    }

    private fun webView() {
        val fileName = "${resources.getString(R.string.lab)}.pdf"

        val path = requireContext().getExternalFilesDir(null)

        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, fileName)

        PdfView.createWebPdfJob(
            requireActivity(),
            webView,
            file,
            fileName,
            object : PdfView.Callback {

                override fun success(path: String) {
                    PdfView.openPdfFile(requireActivity(), path)
                }

                override fun failure() {

                }
            })
    }

    private fun getTextHtml(
        listWidth: List<SpinnerLabItem>,
        listHeight: List<SpinnerLabItem>
    ): String {
        return "" +
                "<h3>${resources.getString(R.string.width_)}</h3>" +
                "<table width=\"100%\" border=\"1\" align=\"center\"\n" +
                "       cellpadding=\"4\" cellspacing=\"0\">\n" +
                "\n" +
                "    <tr>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.lab_col_1)}</th>\n" +
                "        <th style=\"width: 50%\" colspan=\"5\">${resources.getString(R.string.measurement_series)}</th>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.mean_mm)}</th>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.infelicity_mm)}</th>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.allowable_infelicity_)}</th>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr>\n" +
                "        <th>1</th>\n" +
                "        <th>2</th>\n" +
                "        <th>3</th>\n" +
                "        <th>4</th>\n" +
                "        <th>5</th>\n" +
                "    </tr>\n" +
                getMeasureTextHtml(listWidth) +
                "</table>" +
                "\n\n" +
                "<div></div>" +
                "<div></div>" +
                "<div></div>" +
                "<div></div>" +
                "<h3>${resources.getString(R.string.height_)}</h3>" +
                "<table width=\"100%\" border=\"1\" align=\"center\"\n" +
                "       cellpadding=\"4\" cellspacing=\"0\">\n" +
                "\n" +
                "    <tr>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.lab_col_1)}</th>\n" +
                "        <th style=\"width: 50%\" colspan=\"5\">${resources.getString(R.string.measurement_series)}</th>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.mean_mm)}</th>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.infelicity_mm)}</th>\n" +
                "        <th style=\"width: 10%\" rowspan=\"2\">${resources.getString(R.string.allowable_infelicity_)}</th>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr>\n" +
                "        <th>1</th>\n" +
                "        <th>2</th>\n" +
                "        <th>3</th>\n" +
                "        <th>4</th>\n" +
                "        <th>5</th>\n" +
                "    </tr>\n" +
                getMeasureTextHtml(listHeight) +
                "</table>"
    }

    private fun getMeasureTextHtml(list: List<SpinnerLabItem>): String {
        var htmlText = ""
        list.forEach { item ->
            var avg = 0.0
            item.measureList.forEach {
                avg += it.toFloat()
            }
            avg /= item.measureList.size

            htmlText += "" +
                    "   <tr>\n" +
                    "   <th>${item.typeName}</th>\n" +
                    getMeasureTextHtmlColumn(item.measureList) +
                    "   <th>${avg}</th>\n" +
                    "   <th>${
                        String.format(
                            "%.2f",
                            (item.typeName.toFloat() - avg).toFloat()
                        )
                    }</th>\n" +
                    "   <th>±1</th>\n" +
                    "   </tr>\n"
        }
        return htmlText
    }

    private fun getMeasureTextHtmlColumn(list: List<String>): String {
        var htmlText = ""
        list.forEach {
            htmlText += "   <th>${String.format("%.2f", it.toFloat())}</th>\n"
        }
        return htmlText
    }
}

