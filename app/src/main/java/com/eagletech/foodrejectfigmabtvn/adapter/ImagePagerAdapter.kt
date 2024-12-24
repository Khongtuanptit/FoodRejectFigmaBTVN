package com.eagletech.foodrejectfigmabtvn.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.model.FoodItem

@SuppressLint("SetTextI18n")
class ImagePagerAdapter(
    private val items: List<FoodItem>,
    private val onItemClick: (FoodItem) -> Unit
) : RecyclerView.Adapter<ImagePagerAdapter.ImagePagerViewHolder>() {
    inner class ImagePagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name_topic: TextView = itemView.findViewById(R.id.name_topic)
        val recipe_count: TextView = itemView.findViewById(R.id.recipe_count)
        val image_data: ImageView = itemView.findViewById(R.id.image_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImagePagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: ImagePagerViewHolder, position: Int) {
        val item = items[position]
        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.image_data)

        holder.name_topic.text = item.title
        holder.recipe_count.text = "${item.recipeCount} recipes"

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }


    }
}