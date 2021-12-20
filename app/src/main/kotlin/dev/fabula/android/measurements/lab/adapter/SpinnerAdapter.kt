package dev.fabula.android.measurements.lab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import dev.fabula.android.R
import dev.fabula.android.measurements.lab.model.SpinnerLabItem


class SpinnerAdapter(context: Context?, counting: Array<SpinnerLabItem>) :
    BaseAdapter() {
    var inflator: LayoutInflater
    var mCounting: Array<SpinnerLabItem>
    override fun getCount(): Int {
        return mCounting.size
    }

    override fun getItem(position: Int): SpinnerLabItem? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val convertView = inflator.inflate(R.layout.lab_fragment_spinner_item_list, null)

        val tvTypeName = convertView.findViewById<View>(R.id.type_name) as TextView
        val tvCount = convertView.findViewById<View>(R.id.count_measure) as TextView

        tvTypeName.text = mCounting[position].typeName
        tvCount.text = "${mCounting[position].measureList.size}/5"
        return convertView
    }

    init {
        inflator = LayoutInflater.from(context)
        mCounting = counting
    }
}