package com.pai.wwcc3

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listView)
        val redColor = Color.parseColor(    "#F00000")
//        listView.setBackgroundColor(redColor)
        listView.adapter = MyCustomerAdapter(this)
    }


    private class MyCustomerAdapter(context: Context): BaseAdapter() {
        private val mContext: Context
        init {
            mContext = context
        }

        private val names = arrayListOf<String>(
                "Donald Trump", "Steve Jobs", "Tim Cook"
        )
        // responsible for how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        // may ignore
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        // may ignore
        override fun getItem(position: Int): Any {
            return "Test String"
        }
        //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textview)
            nameTextView.text = names.get(position)

            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Row number: $position"

            return rowMain

//            val textView = TextView(mContext) //To change body of created functions use File | Settings | File Templates.
//            textView.text = "Here is row for my listview"
//            return textView
        }
    }
}
