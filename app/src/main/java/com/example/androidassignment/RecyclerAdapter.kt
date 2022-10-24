package com.example.androidassignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(var m_list : List<Movie>, var context : Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var iImg : ImageView
        var iTitle : TextView

        init {
            iImg = itemView.findViewById(R.id.image)
            iTitle = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list, parent, false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iTitle.text = m_list[position].title
        Glide.with(context).load("https://image.tmdb.org/t/p/original" + m_list[position].poster_path)
            .into(holder.iImg)

        /*holder.iImg.setImageResource(imgIds[position])
        holder.iTitle.text = titles[position]

        // Extras for export
        val img = imgIds[position]
        val description = details[position]*/

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title", m_list[position].title)
            intent.putExtra("image", m_list[position].poster_path)
            intent.putExtra("details", m_list[position].overview)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return m_list.size
    }
}