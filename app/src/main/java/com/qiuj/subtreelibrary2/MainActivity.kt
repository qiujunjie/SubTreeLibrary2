package com.qiuj.subtreelibrary2

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var arr: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById(R.id.test1) as ListView
        arr = ArrayList()
        for (i in 0..49) {
            arr!!.add(i.toString() + " ====")
        }
        listView.adapter = MyAdapter(this)
    }

    internal inner class MyAdapter(context: Context) : BaseAdapter() {
        var inflater: View

        init {
            inflater = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null)
        }

        override fun getCount(): Int {
            return arr!!.size
        }

        override fun getItem(position: Int): String {
            return arr!![position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            if (convertView == null) {
                convertView = inflater
            }

            val viewById = convertView.findViewById(android.R.id.text1) as TextView
            viewById.text = this.getItem(position)

            return convertView
        }
    }
}
