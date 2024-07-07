package com.durand.retofinancieraoh.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.durand.retofinancieraoh.R
import com.durand.retofinancieraoh.data.response.banner.BannerMovieResponse

class BannerViewPagerAdapter(private val items: List<BannerMovieResponse>, val context: Context) :
    RecyclerView.Adapter<BannerViewPagerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(context)
            .load(item.image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}