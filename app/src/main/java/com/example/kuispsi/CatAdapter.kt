package com.example.kuispsi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatAdapter(private val list: List<CatModel>):RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    inner class CatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(catResponse: CatModel){
            with(itemView){
                val text: String? = catResponse.text
                Glide.with(this)
                    .load(text)
                    .into(findViewById<ImageView>(R.id.imgCatItem))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}