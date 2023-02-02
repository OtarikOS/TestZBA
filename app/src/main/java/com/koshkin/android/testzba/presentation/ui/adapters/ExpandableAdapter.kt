package com.koshkin.android.testzba.presentation.ui.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.testzba.R


class ExpandableAdapter(
    private val items: List<Item>,
    private val nestedClickListener: (View)->Unit,
    private val deleteClickListener: (View)-> Unit,
    private val transitionFunc: (View,CardView)->Unit,
    private val transitionReverse:(View,CardView)->Unit
): RecyclerView.Adapter<ExpandableAdapter.ExpandableViewHolder>(){

    class ExpandableViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val rootLayout: CardView = view.findViewById(R.id.root_layout)
        val list: RecyclerView = view.findViewById(R.id.recycler_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExpandableViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_card_bin,parent,false))

    override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) {
        val item = items[position]

        with(holder){
            itemView.setOnClickListener {
                when(list.visibility){
                    VISIBLE ->{
                        transitionReverse(list,rootLayout)
                        list.visibility = GONE
                    }
                    GONE ->{
                        transitionFunc(list,rootLayout)
                        list.visibility = VISIBLE
                    }
                }
                list.adapter = NestedAdapter(item.nestedItems) {nestedClickListener(it)}
            }
        }
    }

    override fun getItemCount() = items.size

}