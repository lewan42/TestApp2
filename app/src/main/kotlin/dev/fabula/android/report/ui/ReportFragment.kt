package dev.fabula.android.report.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.print.PdfView
import android.print.PdfView.openPdfFile
import android.text.format.DateUtils
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dev.fabula.android.R
import dev.fabula.android.app.ui.*
import dev.fabula.android.app.util.Util
import dev.fabula.android.bluetooth.bluetooth.BLEConnection
import dev.fabula.android.databinding.ReportFragmentBinding
import dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure
import dev.fabula.android.list.items.model.ListItem
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.report.di.ReportComponent
import dev.fabula.android.station.peregon.model.StationPeregon
import kotlinx.android.synthetic.main.report_fragment.*
import kotlinx.coroutines.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ReportFragment : ViewModelFragment<ReportFragmentBinding>(R.layout.report_fragment) {

    private var platform: Platform? = null
    private val viewModel: ReportViewModel by activityViewModel()
    private var curMeasurementList: List<Measurement>? = null
    private val formatDate: String = "dd/MM/yyyy"
    private var platformStation: StationPeregon? = null
    private var stationType: String = ""
    private var measurementPlatformListTor: List<DimensionsWithMeasure>? = null

    private lateinit var signature: String

    var dateAndTime: Calendar = Calendar.getInstance()

    private val listItem get() = arguments?.getParcelable<ListItem>("listItem")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ReportComponent.create(context).inject(this)
    }

    private fun setInitialDateTime() {
        binding?.let {
            currentDate.text = DateUtils.formatDateTime(
                requireContext(),
                dateAndTime.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )

            listItem?.let {
                when (it.name) {

                    resources.getString(R.string.platform) -> {
                        viewModel.getMeasurementsOfPlatform(it.id)
                    }
                    resources.getString(R.string.canopy) -> {
                        viewModel.getCanopyOfPlatform(it.id)
                    }
                }
            }
        }
    }

    // установка обработчика выбора даты
    var d =
        OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateAndTime.set(Calendar.YEAR, year)
            dateAndTime.set(Calendar.MONTH, monthOfYear)
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            setInitialDateTime()
        }


    private fun setDeviceNull() {
        val filter = IntentFilter(BLEConnection.BLUETOOTH_CONNECTION_REFUSED)

        val receiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {
                Util.BOSCH_DEVICE = ""
            }
        }

        requireContext().registerReceiver(receiver, filter)
    }

    @SuppressLint("LogNotTimber")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signature = setWithoutSignature()
        setInitialDateTime()
        setDeviceNull()

        binding = ReportFragmentBinding.bind(view).apply {

            listItem?.let {
                viewModel.getPlatformById(it.id)

                when (it.name) {

                    resources.getString(R.string.platform) -> {

                        certificate.setText(Util.CERTIFICATE_3 + " " + Util.CERTIFICATE_4)
                        reportToCanopy.visibility = View.GONE
                        reportToPlatform.visibility = View.VISIBLE
                    }
                    resources.getString(R.string.canopy) -> {

                        reportToCanopy.visibility = View.VISIBLE
                        reportToPlatform.visibility = View.GONE
                    }
                }
            }


            btnDate.setOnClickListener {
                DatePickerDialog(
                    requireContext(), d,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

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

            viewModel.canopy.observe(requireActivity(), {
                viewModel.getMeasurementsOfCanopy(it.uid)
            })

            viewModel.measurementsOfCanopy.observe(requireActivity(), { list ->

                curMeasurementList = list.filter {
                    getDateTime(it.created_at.toString()) ==
                            SimpleDateFormat(formatDate).format(
                                Date(dateAndTime.timeInMillis)
                            )
                }
            })

            viewModel.measurementPlatforms.observe(requireActivity(), { list ->

                curMeasurementList = list.filter {
                    getDateTime(it.created_at.toString()) ==
                            SimpleDateFormat(formatDate).format(
                                Date(dateAndTime.timeInMillis)
                            )
                }
            })

            viewModel.platform.observe(requireActivity(), {
                platform = it
                viewModel.getStationPeregon(it.station_uid)
                viewModel.getDimensionList(it.uid)
            })

            viewModel.station.observe(requireActivity(), {
                platformStation = it
                stationType =
                    if (it.type_of == "Station") "${resources.getString(R.string.station)}" else "${
                        resources.getString(R.string.peregon)
                    }"
            })

            viewModel.dimensionFence.observe(requireActivity(), {
                measurementPlatformListTor = it
            })


            btnCreateReport.setOnClickListener {

                if (currentDate.text.equals(resources.getString(R.string.date_not_selected))) {
                    Toast.makeText(
                        requireContext(),
                        resources.getString(R.string.select_date),
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }


                val builder = AlertDialog.Builder(requireContext())
                with(builder) {
                    setTitle(resources.getString(R.string.creating_report))
                    setMessage(resources.getString(R.string.sign_document))
                    setPositiveButton(resources.getString(R.string.yes)) { dialog, whichButton ->
                        dialog.dismiss()
                        signature()
                    }
                    setNegativeButton(resources.getString(R.string.no)) { dialog, whichButton ->
                        dialog.dismiss()
                        report()
                    }

                    val dialog = builder.create()

                    dialog.show()
                }
            }

            LayoutHeaderViewHolder(layoutHeader, requireContext()).apply {
                onItemClickImage = {
                    findNavController().navigate(R.id.action_report_to_profile)
                }
                onItemClickButtonBack = {
                    findNavController().navigateUp()
                }
            }.bind("${resources.getString(R.string.creating_report)}: ${listItem?.name}")
        }
    }


    private fun report() {

        var htmlData = ""
        listItem?.let {
            when (it.name) {

                resources.getString(R.string.platform) -> {
                    curMeasurementList?.let { measure ->
                        if (measure.isNotEmpty()) {
                            htmlData = getPlatformReport(measure)

                            webView.loadDataWithBaseURL(
                                null,
                                htmlData,
                                "text/HTML",
                                "UTF-8",
                                null
                            )
                        } else {
                            Toast.makeText(
                                requireContext(),
                                resources.getString(R.string.not_measurement_in_selection_date),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                }
                resources.getString(R.string.canopy) -> {
                    curMeasurementList?.let { measure ->
                        if (measure.isNotEmpty()) {
                            htmlData = getCanopyReport(measure)

                            webView.loadDataWithBaseURL(
                                null,
                                htmlData,
                                "text/HTML",
                                "UTF-8",
                                null
                            )
                        } else {
                            Toast.makeText(
                                requireContext(),
                                resources.getString(R.string.not_measurement_in_selection_date),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
                else -> {
                }
            }
        }



        webView.webViewClient = object : WebViewClient() {
            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                webView()
            }
        }
    }

    private fun webView() {
        var fileName = "${resources.getString(R.string.report)}.pdf"
        listItem?.let {
            when (it.name) {

                resources.getString(R.string.platform) -> {
                    fileName = "${resources.getString(R.string.report_platform)}.pdf"
                }
                resources.getString(R.string.canopy) -> {
                    fileName = "${resources.getString(R.string.report_canopy)}.pdf"
                }
            }
        }

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
                    openPdfFile(requireActivity(), path)
                }

                override fun failure() {

                }
            })
    }


    private fun getDateTime(s: String): String {
        try {
            val sdf = SimpleDateFormat(formatDate)
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    private fun setWithoutSignature(): String {
        return "<div class=\"signature\">" +
                "    <h4 style=\"text-align: center; margin: 8px; color: darkblue;font-weight: bold\">${
                    resources.getString(
                        R.string.document_have_not_electronic_signature
                    )
                }</h4>" +
                "</div>"
    }

    private fun setSignature(key1: String, key2: String): String {
        return "<div class=\"signature\" style=\"bottom: 10%;\">" +
                "    <h4 style=\"text-align: center; margin: 8px; color: darkblue;font-weight: bold\">${
                    resources.getString(
                        R.string.document_have_not_electronic_signature
                    )
                }</h4>" +
                "    <h5 class=\"inl-txt\" style=\"margin: 8px 0 8px 8px; color: darkblue\">${
                    resources.getString(
                        R.string.certificate
                    )
                }: </h5>" +
                "    <h5 class=\"inl-txt\" style=\"margin: 8px 0; color: darkblue\">" + key1 + "</h5>" +
                "</div>" +
                "" +
                "<div class=\"signature\" style=\"bottom: 1%;\">" +
                "    <h4 style=\"text-align: center; margin: 8px; color: darkblue;font-weight: bold\">${
                    resources.getString(
                        R.string.document_have_not_electronic_signature
                    )
                }</h4>" +
                "    <h5 class=\"inl-txt\" style=\"margin: 8px 0 8px 8px; color: darkblue\">${
                    resources.getString(
                        R.string.certificate
                    )
                }: </h5>" +
                "    <h5 class=\"inl-txt\" style=\"margin: 8px 0; color: darkblue\">" + key2 + "</h5>" +
                "</div>"
    }

    private fun signature() {
        Util.NFC_TAG.value = null

        Util.NFC_TAG_NEXT = true
        val builder1 = AlertDialog.Builder(requireContext())
        var key1: String = ""

        with(builder1) {
            setTitle(resources.getString(R.string.signature_document))
            setMessage(resources.getString(R.string.attach_nfc_tag_one))
            setCancelable(false)

            setNegativeButton(resources.getString(R.string.action_cancel)) { dialog1, whichButton ->
                dialog1.dismiss()
            }

            val dialog1 = builder1.create()
            dialog1.show()


            Util.NFC_TAG.observe(viewLifecycleOwner) { it1 ->
                it1?.let {

                    if (key1 == "") {
                        Util.NFC_TAG_NEXT = false
                        key1 = byteArrayToHexString(it.id)
                        dialog1.dismiss()
                        cooldown()

                    } else if (Util.NFC_TAG_NEXT) {
                        Util.NFC_TAG_NEXT = false
                        dialog1.dismiss()
                        signature = setSignature(key1, byteArrayToHexString(it.id))
                        Util.NFC_TAG.value = null
                        report()
                    }
                }
            }
        }
    }

    private fun cooldown() =
        CoroutineScope(Dispatchers.Main).launch {

            val progressDialog = ProgressDialog(requireContext())
            progressDialog.setMessage(resources.getString(R.string.please_and_wait))
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            delay(5000)
            progressDialog.hide()

            val builder1 = AlertDialog.Builder(requireContext())

            with(builder1) {
                setTitle(resources.getString(R.string.signature_document))
                setMessage(resources.getString(R.string.attach_nfc_tag_two))
                setCancelable(false)

                setNegativeButton(resources.getString(R.string.action_cancel)) { dialog1, whichButton ->
                    dialog1.dismiss()
                }

                val dialog1 = builder1.create()
                dialog1.show()

                Util.NFC_TAG_NEXT = true
            }
        }

    private fun byteArrayToHexString(inarray: ByteArray): String {
        var i: Int
        var j: Int
        var `in`: Int
        val hex = arrayOf(
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F"
        )
        var out = ""
        j = 0
        while (j < inarray.size) {
            `in` = inarray[j].toInt() and 0xff
            i = `in` shr 4 and 0x0f
            out += hex[i]
            i = `in` and 0x0f
            out += hex[i]
            ++j
        }
        return out
    }

    private fun getCanopyReport(measurements: List<Measurement>): String {
        var dataTable = ""
        for ((index, value) in measurements.withIndex()) {
            if (index == 10) break


            dataTable += "" +
                    "    <tr>" +
                    "        <th colspan=\"2\" style=\"text-align: center\">" +
                    "            <p class=\"inl-txt\">" + (index + 1) + "</p>" +
                    "        </th>" +
                    "        <th colspan=\"2\" style=\"text-align: center\">" +
                    "            <p class=\"inl-txt\">" + measurements[index].horizontal_gabarit + "</p>" +
                    "        </th>" +
                    "        <th colspan=\"2\" style=\"text-align: center\">" +
                    "            <p class=\"inl-txt\">" + measurements[index].vertical_gabarit + "</p>" +
                    "        </th>" +
                    "        <th colspan=\"3\" style=\"text-align: center\">" +
                    "            <p class=\"inl-txt\"></p>" +
                    "        </th>" +
                    "        <th colspan=\"3\" style=\"text-align: center\">" +
                    "            <p class=\"inl-txt\"></p>" +
                    "        </th>" +
                    "    </tr>"

        }

        return "" +
                "<style>" +
                "    .inl-txt {" +
                "        display: inline-block;" +
                "    }" +
                "" +
                "    .underline {" +
                "        text-decoration: underline" +
                "    }" +
                "" +
                "    p {" +
                "        margin: 0;" +
                "    }" +
                "" +
                "    td {" +
                "        text-align: center;" +
                "    }" +
                "" +
                "    .signature {" +
                "" +
                "        width: 300px;" +
                "        border: 3px solid darkblue;" +
                "        border-radius: 10px;" +
                "        position: absolute;" +
                "        display: block;" +
                "        right: 10%;" +
                "        bottom: 10%;" +
                "    }" +
                "" +
                "    .row {" +
                "        margin: 10px;" +
                "    }" +
                "</style>" +
                "" +
                "<body>" +
                "" +
                "<p style=\"display: block; text-align: center\">${resources.getString(R.string.bill)}</p>" +
                "<div>" +
                "    <p class=\"inl-txt\"></p>" +
                "    <p class=\"inl-txt\" style=\"text-decoration: underline; float:right;\">" + currentDate.text.toString() + "</p>" +
                "</div>" +
                "" +
                "<div class=\"row\" style=\"display: block; border-bottom: 2px solid black\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">${resources.getString(R.string.measurement_of_size_canopy)}</p>" +
                "        <p class=\"inl-txt underline\">VALUE</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\" style=\"display: block; border-bottom: 2px solid black\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">${resources.getString(R.string.passenger_platform_on_station)}</p>" +
                "        <p class=\"inl-txt\">VALUE</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<table width=\"100%\" border=\"1\" align=\"center\"" +
                "       cellpadding=\"4\" cellspacing=\"0\">" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: left\">" +
                "            <div>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.binding)}:</p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.km)}, </p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.pk)} </p>" +
                "            </div>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: left\">" +
                "            <div>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.binding)}:</p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.km)}, </p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.pk)} </p>" +
                "            </div>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: left\">" +
                "            value" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: left\">" +
                "            value" +
                "        </th>" +
                "    </tr>" +
                "" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: left\">" +
                "            <div>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.measurement_made_from_side)}</p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\"> ${resources.getString(R.string.each)} </p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.m)}</p>" +
                "            </div>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: left\">" +
                "            <div>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.measurement_made_from_side)}</p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\"> ${resources.getString(R.string.each)} </p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.m)}</p>" +
                "            </div>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <div>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.symbol_number_path)}</p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "            </div>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <div>" +
                "                <p class=\"inl-txt\">${resources.getString(R.string.symbol_number_path)}</p>" +
                "                <p class=\"inl-txt underline\">VALUE</p>" +
                "            </div>" +
                "        </th>" +
                "" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"2\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">№ п/п.</p>" +
                "        </th>" +
                "        <th colspan=\"2\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Расстояние от оси пути до ж.д. (L, мм).</p>" +
                "        </th>" +
                "        <th colspan=\"2\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">От УГР (H, мм).</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Расстояние от оси пути до ж.д. (L, мм).</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">От УГР (H, мм).</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                dataTable +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">${resources.getString(R.string.norm)}</p>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">${resources.getString(R.string.norm)}</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Норма value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Норма value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Норма value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Норма value</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">${resources.getString(R.string.tolerances)}</p>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">${resources.getString(R.string.tolerances)}</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Допуски value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Допуски value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Допуски value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Допуски value</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">${resources.getString(R.string.canopy)}</p>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">${resources.getString(R.string.canopy)}</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Павильон, навес, (козырек) value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Павильон, навес, (козырек) value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Павильон, навес, (козырек) value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Павильон, навес, (козырек) value</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Категория навеса</p>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Категория навеса</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Категория навеса value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Категория навеса value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Категория навеса value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Категория навеса value</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Критические точки</p>" +
                "        </th>" +
                "        <th colspan=\"6\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Критические точки</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Критические точки value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Критические точки value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Критические точки value</p>" +
                "        </th>" +
                "        <th colspan=\"3\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Критические точки value</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th rowspan=\"2\" colspan=\"4\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">Промеры произведены:</p>" +
                "        </th>" +
                "" +
                "        <th  colspan=\"4\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">" + Util.CERTIFICATE_5 + " " + Util.CERTIFICATE_1 + "</p>" +
                "        </th>" +
                "" +
                "        <th  colspan=\"4\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">" + Util.CERTIFICATE_2 + "</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "" +
                "        <th  colspan=\"4\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">" + Util.CERTIFICATE_3 + "</p>" +
                "        </th>" +
                "" +
                "        <th  colspan=\"4\" style=\"text-align: center\">" +
                "            <p class=\"inl-txt\">" + Util.CERTIFICATE_4 + "</p>" +
                "        </th>" +
                "    </tr>" +
                "" +
                "</table>" +
                "" +
                signature +
                "<p>Промеры производил:</p>" +
                "<div class=\"row\" style=\"margin-left: auto; width: 65%\">" +
                "    <div class=\"row\">" +
                "        <p class=\"inl-txt underline\" style=\"width: 150px\">" + binding?.position1?.text.toString() + "</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.userName1?.text.toString() + "</p>" +
                "    </div>" +
                "" +
                "    <div class=\"row\">" +
                "        <p class=\"inl-txt underline\" style=\"width: 150px\">" + binding?.position2?.text.toString() + "</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.userName2?.text.toString() + "</p>" +
                "    </div>" +
                "" +
                "    <div class=\"row\">" +
                "        <p class=\"inl-txt underline\" style=\"width: 150px\">" + binding?.position3?.text.toString() + "</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.userName3?.text.toString() + "</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "</body>"
    }

    private fun getPlatformReport(measurements: List<Measurement>): String {

        var dataTable = ""
        for ((index, value) in measurements.withIndex()) {
            if (index == 24) break

            if (measurements.size > index + 25) {
                dataTable += "<tr>" +
                        "        <td>" + (index + 1) + "</td>" +
                        "        <td>" + binding?.widthNorm?.text.toString() + "</td>" +
                        "        <td>" + measurements[index].horizontal_gabarit + "</td>" +
                        "        <td>" + binding?.heightNorm?.text.toString() + "</td>" +
                        "        <td>" + measurements[index].vertical_gabarit + "</td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "        <td>" + (index + 26) + "</td>" +
                        "        <td>" + binding?.widthNorm?.text.toString() + "</td>" +
                        "        <td>" + measurements[index + 25].horizontal_gabarit + "</td>" +
                        "        <td>" + binding?.heightNorm?.text.toString() + "</td>" +
                        "        <td>" + measurements[index + 25].vertical_gabarit + "</td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "    </tr>"
            } else {
                dataTable += "<tr>" +
                        "        <td>" + (index + 1) + "</td>" +
                        "        <td>" + binding?.widthNorm?.text.toString() + "</td>" +
                        "        <td>" + measurements[index].horizontal_gabarit + "</td>" +
                        "        <td>" + binding?.heightNorm?.text.toString() + "</td>" +
                        "        <td>" + measurements[index].vertical_gabarit + "</td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "        <td>" + (index + 26) + "</td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "        <td></td>" +
                        "    </tr>"
            }
        }

        return "<style>" +
                "    .inl-txt {" +
                "        display: inline-block;" +
                "    }" +
                "" +
                "    .underline {" +
                "        text-decoration: underline" +
                "    }" +
                "" +
                "    p {" +
                "        margin: 0;" +
                "    }" +
                "" +
                "    td {" +
                "        text-align: center;" +
                "    }" +
                "" +
                "    .signature {" +
                "" +
                "        width: 300px;" +
                "        border: 3px solid darkblue;" +
                "        border-radius: 10px;" +
                "        position: absolute;" +
                "        display: block;" +
                "        right: 10%;" +
                "        bottom: 10%;" +
                "    }" +
                "" +
                "    .row {" +
                "        margin: 10px;" +
                "    }" +
                "</style>" +
                "" +
                "<body>" +
                "" +
                "" +
                "<p style=\"display: block; text-align: center\">ВЕДОМОСТЬ</p>" +
                "<div>" +
                "    <p class=\"inl-txt\"></p>" +
                "    <p class=\"inl-txt\" style=\"text-decoration: underline; float:right;\">" + binding?.currentDate?.text.toString() + "</p>" +
                "</div>" +
                "" +
                "<div class=\"row\" style=\"display: block; text-align: center\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">промера габарита </p>" +
                "        <p class=\"inl-txt underline\">" + platform?.type1 + " " + platform?.type2 + "</p>" +
                "        <p class=\"inl-txt\" style=\"text-align: right\">пассажирской</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\" style=\"display: block; text-align: center\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">платформы на станции(остоновочном пункте) </p>" +
                "        <p class=\"inl-txt underline\">" + platformStation?.name + "</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\" style=\"display: block; text-align: center\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">по </p>" +
                "        <p class=\"inl-txt underline\">" + binding?.numberPath?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">пути. Промеры в створе каждого блока на</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.block?.text.toString() + "</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "" +
                "<div class=\"row\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">Привязка: начало</p>" +
                "" +
                "        <p class=\"inl-txt underline\">" + binding?.startKm?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">км, </p>" +
                "" +
                "        <p class=\"inl-txt underline\">" + binding?.startPk?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">пк </p>" +
                "" +
                "        <p class=\"inl-txt underline\">" + binding?.startM?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">; конец </p>" +
                "" +
                "        <p class=\"inl-txt underline\">" + binding?.endKm?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">км, </p>" +
                "" +
                "        <p class=\"inl-txt underline\">" + binding?.endPk?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">пк </p>" +
                "" +
                "        <p class=\"inl-txt underline\">" + binding?.endM?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">м. </p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">План пути:</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.planPath?.text.toString() + "</p>" +
                "" +
                "        <p class=\"inl-txt\">, R= </p>" +
                "        <p class=\"inl-txt underline\">" + binding?.r?.text.toString() + "</p>" +
                "" +
                "        <p class=\"inl-txt\">, h= </p>" +
                "        <p class=\"inl-txt underline\">" + binding?.h?.text.toString() + "</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">Промеры осуществлялись со стороны</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.direction?.text.toString() + "</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">Промеры производились через </p>" +
                "        <p class=\"inl-txt underline\">" + binding?.rangeStep?.text.toString() + "</p>" +
                "        <p class=\"inl-txt\">метров от торца платформы</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<div class=\"row\">" +
                "    <div class=\"inl-txt\">" +
                "        <p class=\"inl-txt\">Промеры произведены: </p>" +
                "        <p class=\"inl-txt underline\">" + binding?.certificate?.text.toString() + "</p>" +
                "    </div>" +
                "</div>" +
                "" +
                "<table width=\"100%\" border=\"1\" align=\"center\"" +
                "       cellpadding=\"4\" cellspacing=\"0\">" +
                "" +
                "    <tr>" +
                "        <th rowspan=\"2\">№ Ригеля</th>" +
                "        <th colspan=\"2\">Горизонтальный L, мм</th>" +
                "        <th colspan=\"2\">Вертикальный H, мм</th>" +
                "        <th rowspan=\"2\">R,м</th>" +
                "        <th rowspan=\"2\">h,м</th>" +
                "" +
                "        <th rowspan=\"2\">№ Ригеля</th>" +
                "        <th colspan=\"2\">Горизонтальный L, мм</th>" +
                "        <th colspan=\"2\">Вертикальный H, мм</th>" +
                "        <th rowspan=\"2\">R,м</th>" +
                "        <th rowspan=\"2\">h,м</th>" +
                "" +
                "    </tr>" +
                "    <tr>" +
                "        <th>Норма</th>" +
                "        <th>Факт</th>" +
                "        <th>Норма</th>" +
                "        <th>Факт</th>" +
                "" +
                "        <th>Норма</th>" +
                "        <th>Факт</th>" +
                "        <th>Норма</th>" +
                "        <th>Факт</th>" +
                "    </tr>" +
                "" +
                "    <tr>" +
                "        <th>1</th>" +
                "        <th>2</th>" +
                "        <th>3</th>" +
                "        <th>4</th>" +
                "        <th>5</th>" +
                "        <th>6</th>" +
                "        <th>7</th>" +
                "        <th>8</th>" +
                "        <th>9</th>" +
                "        <th>10</th>" +
                "        <th>11</th>" +
                "        <th>12</th>" +
                "        <th>13</th>" +
                "        <th>14</th>" +
                "    </tr>" +
                dataTable +
                "</table>" +
                "" +
                signature +
                "" +
                "<p style=\"text-align: center\">Габарит торцевого ограждения платформы</p>" +
                "" +
                "<div style=\"display: grid; grid-template-columns: 1fr 1fr 1fr 1fr;\">" +
                getDimensionFence() +
                "</div>" +
                "" +
                "<div class=\"row\">" +
                "    <p>Прочие нарушения в содержании платформы (разрушение асфальта, фундаментальных блоков, плит перекрытия): </p>" +
                "    <p class=\"underline\">" + binding?.descriptionProblems?.text.toString() + "</p>" +
                "</div>" +
                "" +
                "<p>Промеры проверяли:</p>" +
                "<div class=\"row\" style=\"margin-left: auto; width: 65%\">" +
                "    <div class=\"row\">" +
                "        <p class=\"inl-txt underline\" style=\"width: 150px\">" + binding?.position1?.text.toString() + "</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.userName1?.text.toString() + "</p>" +
                "    </div>" +
                "" +
                "    <div class=\"row\">" +
                "        <p class=\"inl-txt underline\" style=\"width: 150px\">" + binding?.position2?.text.toString() + "</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.userName2?.text.toString() + "</p>" +
                "    </div>" +
                "" +
                "    <div class=\"row\">" +
                "        <p class=\"inl-txt underline\" style=\"width: 150px\">" + binding?.position3?.text.toString() + "</p>" +
                "        <p class=\"inl-txt underline\">" + binding?.userName3?.text.toString() + "</p>" +
                "    </div>" +
                "</div>" +
                "</body>"
    }

    private fun getDimensionFence(): String {
        var dimensions = ""
        measurementPlatformListTor?.forEach { item ->
            dimensions +=
                "<div>" +
                        "        <p>" + item.direction + "</p>" +
                        "        <div>" +
                        "            <p class=\"inl-txt\">H - </p>" +
                        "            <p class=\"inl-txt\">" + item.horizontal + "</p>" +
                        "            <p class=\"inl-txt\">мм</p>" +
                        "        </div>" +
                        "        <div>" +
                        "            <p class=\"inl-txt\">B - </p>" +
                        "            <p class=\"inl-txt\">" + item.vertical + "</p>" +
                        "            <p class=\"inl-txt\">мм</p>" +
                        "        </div>" +
                        "    </div>"
        }

        return dimensions
    }
}

