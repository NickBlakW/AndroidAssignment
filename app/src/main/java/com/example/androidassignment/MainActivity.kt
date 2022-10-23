package com.example.androidassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    /*private var manager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null*/

    private lateinit var movieList : ArrayList<Movie>
    private lateinit var iVal : String
    private lateinit var retroClient: RetroClient
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iVal = intent.getStringExtra("Type").toString()
        retroClient = RetroClient(iVal)
        recycler = findViewById(R.id.recycler)

        initMovies()
    }

    private fun inflateRecycler(list : List<Movie>) {
        val adapter = RecyclerAdapter(list, baseContext)
        recycler.layoutManager = LinearLayoutManager(baseContext)
        recycler.adapter = adapter
    }

    private fun initMovies() {
        val retroData : Call<JResponse> = retroClient.getRetroClient().fetchData()

        retroData.enqueue(object : Callback<JResponse?> {
            override fun onResponse(call: Call<JResponse?>, response: Response<JResponse?>) {
                val json : JResponse = response.body()!!
                movieList = json.results
                inflateRecycler(movieList)
            }

            override fun onFailure(call: Call<JResponse?>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })
    }
}