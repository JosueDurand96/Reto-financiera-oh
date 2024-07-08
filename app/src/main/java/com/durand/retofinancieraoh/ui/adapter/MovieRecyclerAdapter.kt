package com.durand.retofinancieraoh.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.durand.retofinancieraoh.R
import com.durand.retofinancieraoh.data.response.peli.PeliMovieResponse

class MovieRecyclerAdapter(private val items: List<PeliMovieResponse>, val context: Context) :
    RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>() {

    private var mOnClickSelectedMovie: OnClickSelectedMovie? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val clickConstraintLayout: ConstraintLayout = itemView.findViewById(R.id.clickConstraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = items[position].title
        holder.clickConstraintLayout.setOnClickListener {
            Log.d("josue", "clickConstraintLayout: ")
            mOnClickSelectedMovie?.onSelectCardBuying(items[position].title)
        }
        val item = items[position]
        Glide.with(context)
            .load(item.image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setListenerItemSelected(setOnClickSelectedMovie: OnClickSelectedMovie) {
        mOnClickSelectedMovie = setOnClickSelectedMovie
    }

    interface OnClickSelectedMovie {
        fun onSelectCardBuying(title: String)
    }
}