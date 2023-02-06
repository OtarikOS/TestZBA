package com.koshkin.android.testzba.presentation.ui.adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.testzba.R
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.presentation.entitypr.Item


class ExpandableAdapter(
    //TODO add animation (transitionFunc, transitionRevers)
    private val context: Context,
    private val bins:List<BinEntities> = arrayListOf(),
    private val items: List<Item>,
    private val nestedClickListener: (String)->Unit,
   // private val deleteClickListener: (View)-> Unit,
  //  private val transitionFunc: (View,CardView)->Unit,
  //  private val transitionReverse:(View,CardView)->Unit
): RecyclerView.Adapter<ExpandableAdapter.ExpandableViewHolder>(){

 //   private val items: List<Item> = arrayListOf()

    class ExpandableViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val rootLayout: CardView = view.findViewById(R.id.root_layout)
        val details: RecyclerView = view.findViewById(R.id.recycler_item)
        val tvBinNumber: TextView = view.findViewById(R.id.number_card)
        val tvBankName:TextView = view.findViewById(R.id.bank_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableViewHolder{
        Log.i("EX_onCVH","yes0")
        return ExpandableViewHolder (
        LayoutInflater.from(context).inflate(R.layout.item_card_bin,parent,false))

    }

    override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) {
        val item = items[position]
//        items[position].id =bins[position].id
//        items[position].text = bins[position].nameBank.toString()
//        holder.tvBinNumber.text = bins[position].id.toString()
//        holder.tvBankName.text = bins[position].nameBank

        Log.i("EX_ADAP","${items.size.toString()} ,${items[0].id}")

        with(holder){
            tvBinNumber.text = item.id.toString()
            tvBankName.text = item.nameBank
            itemView.setOnClickListener {
                Log.i("EX_onBVH",item.nameBank)
                when(details.visibility){
                    VISIBLE ->{
                     //   transitionReverse(details,rootLayout)
                        details.visibility = GONE
                    }
                    GONE ->{
                    //    transitionFunc(details,rootLayout)
                        details.visibility = VISIBLE
                    }
                }
                details.adapter = NestedAdapter(item.nestedItems) {nestedClickListener(it)}
            }
        }
    }

    override fun getItemCount() = items.size

}