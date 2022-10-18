package com.example.androidassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val titles = arrayOf(
        "Django Unchained",
        "Get Out",
        "Gladiator",
        "Pulp Fiction",
        "Saving Private Ryan",
        "Shrek",
    )

    val imgIds = arrayOf(
        R.drawable.djangounchained,
        R.drawable.getout,
        R.drawable.gladiator,
        R.drawable.pulpfiction,
        R.drawable.ryan,
        R.drawable.shrek,
    )

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var iImg : ImageView
        var iTitle : TextView

        init {
            iImg = itemView.findViewById(R.id.img)
            iTitle = itemView.findViewById(R.id.title)

            itemView.setOnClickListener { v : View ->
                var pos : Int = adapterPosition

                Snackbar.make(v, "Clicked $pos", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list, parent, false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iImg.setImageResource(imgIds[position])
        holder.iTitle.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}