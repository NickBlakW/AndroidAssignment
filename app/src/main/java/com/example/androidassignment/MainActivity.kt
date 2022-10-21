package com.example.androidassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var manager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)

        manager = LinearLayoutManager(this)
        recycler.layoutManager = manager

        adapter = RecyclerAdapter(this)
        recycler.adapter = adapter

        /*
        // Go to details activity
        val intent = Intent(this, DetailsActivity::class.java)

        startActivity(intent)*/
    }
}