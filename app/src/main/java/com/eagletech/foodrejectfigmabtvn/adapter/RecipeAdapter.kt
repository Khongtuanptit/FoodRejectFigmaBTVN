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
import com.eagletech.foodrejectfigmabtvn.model.RecipeItem

class RecipeAdapter(
    private val items: List<RecipeItem>,
    private val onItemClick: (RecipeItem) -> Unit,
    private val onLikeClick: (RecipeItem) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image_recipes_of_week: ImageView = itemView.findViewById(R.id.image_recipes_of_week)
        val title: TextView = itemView.findViewById(R.id.title)
        val like: ImageView = itemView.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipes_of_week, parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.image_recipes_of_week)

        holder.title.text = item.title
        if (item.isLike) {
            holder.like.setImageResource(R.drawable.ic_like2)
        } else {
            holder.like.setImageResource(R.drawable.ic_like)
        }

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

        holder.like.setOnClickListener {
            item.isLike = !item.isLike
            notifyDataSetChanged()
            onLikeClick(item)
        }


    }
}