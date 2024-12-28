package com.jesse.c24.g2.perritos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesse.c24.R
import com.jesse.c24.databinding.ItemSmallDogsBinding
import com.squareup.picasso.Picasso

class DogsAdapter(private val list: List<String>) : RecyclerView.Adapter<DogsVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogsVH(layoutInflater.inflate(R.layout.item_small_dogs, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DogsVH, position: Int) {
        holder.bind(list[position])
    }
}

class DogsVH(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSmallDogsBinding.bind(view)

    fun bind(image: String) {
       Picasso.get().load(image).into(binding.name)
    }
}