package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        loadData()
    }

    private fun loadData() {
        val img = findViewById<ImageView>(R.id.m_img)
        val ctxImg = intent.getStringExtra("image")
        Glide.with(baseContext).load("https://image.tmdb.org/t/p/original" + ctxImg.toString())
            .into(img)

        val titleView = findViewById<TextView>(R.id.m_title)
        titleView.text = intent.getStringExtra("title")

        val details = findViewById<TextView>(R.id.m_details)
        details.text = intent.getStringExtra("details")
    }
}