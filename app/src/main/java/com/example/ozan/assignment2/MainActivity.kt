package com.example.ozan.assignment2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

import java.util.Scanner

class MainActivity : AppCompatActivity() {

    private var mSpinner: Spinner? = null
    private var mPoster: ImageView? = null
    private var mExplain: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSpinner = findViewById(R.id.movieSpinner)
        mPoster = findViewById(R.id.posterView)
        mExplain = findViewById(R.id.explain)

        mSpinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                var title = mSpinner!!.selectedItem as String
                title = title.toLowerCase().replace(" ", "_")
                setText(title)
                setPicture(title)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // nothing to do
            }
        }
    }

    private fun setText(title: String) {
        var result = ""

        val id = resources.getIdentifier(title, "raw", packageName)
        val `in` = Scanner(resources.openRawResource(id))

        while (`in`.hasNext()) {
            result += `in`.nextLine()
        }
        `in`.close()

        mExplain!!.text = result
    }

    private fun setPicture(title: String) {
        val id = resources.getIdentifier(title, "drawable", packageName)
        mPoster!!.setImageResource(id)
    }
}