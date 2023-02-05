package com.koshkin.android.testzba.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.testzba.R

class NestedAdapter(
    private val items: List<String>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {
    class NestedViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.textView_info)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        return NestedViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.nested_layout,parent,false))
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        val item = items[position]

        with(holder) {
            text.text = item
         //   itemView.setOnClickListener { clickListener(item) }
        }
    }

    override fun getItemCount()=items.size

}
