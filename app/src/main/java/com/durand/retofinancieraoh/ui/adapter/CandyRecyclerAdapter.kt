package com.durand.retofinancieraoh.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.durand.retofinancieraoh.R
import com.durand.retofinancieraoh.data.response.candy.CandyResponse
import com.durand.retofinancieraoh.data.response.peli.PeliMovieResponse

class CandyRecyclerAdapter(private val items: List<CandyResponse>, val context: Context) :
    RecyclerView.Adapter<CandyRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val dismissImageView: ImageView = itemView.findViewById(R.id.dismissImageView)
        val addImageView: ImageView = itemView.findViewById(R.id.addImageView)
        val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_candy_store, parent, false)
        return ViewHolder(view)
    }
    private var count = 0

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = items[position].title
        holder.priceTextView.text = items[position].price
        holder.descriptionTextView.text = items[position].description

        holder.addImageView.setOnClickListener {
            count++
            holder.amountTextView.text = count.toString()
            notifyDataSetChanged()
        }
        holder.dismissImageView.setOnClickListener {
            count--
            if (count <= 0) {
                holder.amountTextView.text = "0"
                notifyDataSetChanged()
            }else{
                holder.amountTextView.text = count.toString()
                notifyDataSetChanged()
            }
        }

        val item = items[position]
        Glide.with(context)
            .load(item.image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}