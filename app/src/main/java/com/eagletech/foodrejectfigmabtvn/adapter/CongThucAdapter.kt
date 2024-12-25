package com.eagletech.foodrejectfigmabtvn.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.model.CongThuc

class CongThucAdapter(
    private val listCongThuc: List<CongThuc>
) : RecyclerView.Adapter<CongThucAdapter.CongThucViewHolder>() {

    inner class CongThucViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ic_ct: ImageView = itemView.findViewById(R.id.ic_ct)
        val ct: TextView = itemView.findViewById(R.id.ct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CongThucViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_congthuc, parent, false)
        return CongThucViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCongThuc.size
    }

    override fun onBindViewHolder(holder: CongThucViewHolder, position: Int) {
        val ct = listCongThuc[position]
        holder.ic_ct.setImageResource(ct.imageRes)
        holder.ct.text = ct.title
    }
}