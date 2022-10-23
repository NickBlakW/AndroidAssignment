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

    val titles = arrayOf(
        "Django Unchained",
        "Get Out",
        "Gladiator",
        "Pulp Fiction",
        "Saving Private Ryan",
        "Shrek",
    )

    val details = arrayOf(
        "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation-owner in Mississippi.",
        "A young African-American visits his white girlfriend's parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point.",
        "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.",
        "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
        "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.",
        "A mean lord exiles fairytale creatures to the swamp of a grumpy ogre, who must go on a quest and rescue a princess for the lord in order to get his land back.",
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