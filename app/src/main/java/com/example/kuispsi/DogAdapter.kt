package com.example.kuispsi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DogAdapter(private val list: List<DogModel>):RecyclerView.Adapter<DogAdapter.DogViewHolder>(){
    inner class DogViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(dogResponse: DogModel){
            with(itemView){
                val text: String? = dogResponse.text
                Glide.with(this)
                    .load(text)
                    .into(findViewById<ImageView>(R.id.imgDogItem))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}