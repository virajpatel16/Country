package com.example.country

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class CountryAdepter(list: List<Countrymodel>, countryclik: Countryclik) :
    RecyclerView.Adapter<CountryAdepter.Countryholder>() {

    lateinit var context: Context
    var Countryclik =countryclik
    var list = list

    class Countryholder(itemView: View) : ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.img)
        var txtcountry = itemView.findViewById<TextView>(R.id.txtCountry)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Countryholder {
        context = parent.context

        return Countryholder(LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size


    }

    override fun onBindViewHolder(holder: Countryholder, position: Int) {
        holder.txtcountry.text = list.get(position).name

        Glide.with(context).load(list.get(position).flags?.png).into(holder.img)

        holder.itemView.setOnClickListener {
            Countryclik.onTap(position)

        }


    }
}





