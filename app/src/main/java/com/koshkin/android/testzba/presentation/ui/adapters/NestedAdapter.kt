package com.koshkin.android.testzba.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.koshkin.android.testzba.R
import com.koshkin.android.testzba.data.entities.BinEntities

class NestedAdapter(
    private val items: BinEntities,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {
    class NestedViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.textView_info)
        val map: TextView = view.findViewById(R.id.textView_map)
        val url: TextView = view.findViewById(R.id.textView_url)
        val phone: TextView = view.findViewById(R.id.textView_phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        return NestedViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.nested_layout,parent,false))
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        val item = items

        with(holder) {
            var info:String = ""
            var increment :String =""
            if(item.scheme!=null) {increment="Scheme: ${item.scheme},"
            info += increment}
            if(item.type!=null) {increment=" Type: ${item.type},"
            info += increment}
            if(item.brand!=null) {increment=" Brand: ${item.brand},"
            info += increment}
            if(item.prepaid!=null) {increment=" Prepaid: ${item.prepaid},"
            info += increment}
            if(item.alpha2!=null) {increment=" Alpha2: ${item.alpha2},"
            info += increment}
            if(item.nameCountry!=null) {increment=" Country: ${item.nameCountry},"
            info += increment}
            if(item.emoji!=null) {increment=" Emoji: ${item.emoji},"
            info += increment}
            if(item.currency!=null) {increment=" Currency: ${item.currency},"
            info += increment}
            if(item.length!=null) {increment=" Length: ${item.length},"
            info += increment}
            if(item.city!=null) {increment=" City: ${item.city},"
            info += increment}
            text.text = info
            if(item.url!=null) url.text = item.url
            else url.visibility = View.GONE
            if(item.nameBank!=null) phone.text = item.phone
            else phone.visibility = View.GONE
            if(item.latitude!= null) map.text = "Longitude: ${item.longitude} Latitude: ${item.latitude}"
            else map.visibility = View.GONE
         //   itemView.setOnClickListener { clickListener(item) }
        }
    }

    override fun getItemCount()=1

}
