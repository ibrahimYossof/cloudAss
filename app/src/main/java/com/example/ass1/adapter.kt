package com.example.ass1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(var context : Context, var data : ArrayList<dataC>) : RecyclerView.Adapter<adapter.viewHolder>() {
    class viewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var names = item.findViewById<TextView>(R.id.nameCon)
        var num = item.findViewById<TextView>(R.id.numberss)
        var addr = item.findViewById<TextView>(R.id.addressCon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var s = LayoutInflater.from(context).inflate(R.layout.item , parent , false)
        return viewHolder(s)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.names.text = data[position].name
        holder.num.text = data[position].number
        holder.addr.text = data[position].address
    }

    override fun getItemCount(): Int {
        return data.size
    }
}