package com.eagletech.foodrejectfigmabtvn.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.model.DetailFoodItem

class DetailFoodItemAdapter(
    private var listDetailFoodItem: List<DetailFoodItem>,
    private val onItemClick: (DetailFoodItem) -> Unit,
    private val onLikeClick: (DetailFoodItem) -> Unit
) : RecyclerView.Adapter<DetailFoodItemAdapter.DetailFoodItemViewHolder>() {

    inner class DetailFoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewFood: ImageView = itemView.findViewById(R.id.imageViewFood)
        val foodTitle: TextView = itemView.findViewById(R.id.foodTitle)
        val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
        val like: ImageView = itemView.findViewById(R.id.like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailFoodItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detail_category, parent, false)
        return DetailFoodItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDetailFoodItem.size
    }

    override fun onBindViewHolder(holder: DetailFoodItemViewHolder, position: Int) {
        val detailFoodItem = listDetailFoodItem[position]

        holder.imageViewFood.setImageResource(detailFoodItem.imageUrl)
        holder.foodTitle.text = detailFoodItem.title
        holder.foodDescription.text = detailFoodItem.description
        if (detailFoodItem.isLike) {
            holder.like.setImageResource(R.drawable.ic_like2)
        } else {
            holder.like.setImageResource(R.drawable.ic_like)
        }

        holder.itemView.setOnClickListener {
            onItemClick(detailFoodItem)
        }

        holder.like.setOnClickListener {
            detailFoodItem.isLike = !detailFoodItem.isLike
            notifyDataSetChanged()
            onLikeClick(detailFoodItem)
        }
    }

    fun updateData(newList: List<DetailFoodItem>) {
        this.listDetailFoodItem = newList
        notifyDataSetChanged()
    }
}