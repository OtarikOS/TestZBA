package com.koshkin.android.testzba.presentation.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NestedAdapter(nestedItems: Any, function: () -> Unit) : RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {
    class NestedViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
