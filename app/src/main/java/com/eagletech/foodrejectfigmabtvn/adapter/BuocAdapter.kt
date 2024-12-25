package com.eagletech.foodrejectfigmabtvn.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.model.Buoc


@SuppressLint("SetTextI18n")
class BuocAdapter(
    private val listBuoc: List<Buoc>
) : RecyclerView.Adapter<BuocAdapter.BuocViewHolder>() {
    inner class BuocViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description_buoc: TextView = itemView.findViewById(R.id.description_buoc)
        val number_buoc: TextView = itemView.findViewById(R.id.number_buoc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuocViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buoc, parent, false)
        return BuocViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBuoc.size
    }


    override fun onBindViewHolder(holder: BuocViewHolder, position: Int) {
        val buoc = listBuoc[position]
        holder.number_buoc.text = buoc.number.toString()
        holder.description_buoc.text = buoc.description

    }
}