package com.example.api

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecylclerAdapter(val agents:ValoModel):
    RecyclerView.Adapter<RecylclerAdapter.ViewHolder>() {
    lateinit var context: Context
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        var agents: TextView = view.findViewById(R.id.agents)
        var img: ImageView = view.findViewById(R.id.valoimage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.valoitems_layout, parent,  false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.agents.text = agents.data[position].displayName
        Glide.with(context).load(agents.data[position].displayIcon).into(holder.img)
        holder.img.setOnClickListener{
        context.startActivity(Intent(context, AgentsInfo::class.java).apply {
            putExtra("info", agents.data[position])
        })




        }
    }

    override fun getItemCount(): Int {
        return agents.data.size
    }
}