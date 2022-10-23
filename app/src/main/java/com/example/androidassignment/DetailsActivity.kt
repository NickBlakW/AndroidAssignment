package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        loadData()
    }

    fun loadData() {
        var titleView = findViewById<TextView>(R.id.m_title)
        titleView.text = intent.getStringExtra("title")

        var imgView = findViewById<ImageView>(R.id.m_img)
        imgView.setImageResource(intent.getIntExtra("image", 0))

        var details = findViewById<TextView>(R.id.m_details)
        details.text = intent.getStringExtra("details")
    }
}