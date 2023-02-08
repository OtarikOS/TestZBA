package com.koshkin.android.testzba.presentation.ui.adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.testzba.R
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.usecases.DeleteBinCardUseCase
import com.koshkin.android.testzba.presentation.ui.BinViewModel
import kotlinx.coroutines.CoroutineScope


class ExpandableAdapter(
    //TODO add animation (transitionFunc, transitionRevers)
    private val context: Context,
  //  private val deleteBinCardUseCase: DeleteBinCardUseCase,
  //  private val bins:List<BinEntities> = arrayListOf(),
    private val items: MutableList<BinEntities>,
    private val nestedClickListener: (String)->Unit,
    private val listener:ActionClickListener,
  //  private val deleteClickListener:  Unit,
  //  private val transitionFunc: (View,CardView)->Unit,
  //  private val transitionReverse:(View,CardView)->Unit
): RecyclerView.Adapter<ExpandableAdapter.ExpandableViewHolder>(){

 //   private val items: List<Item> = arrayListOf()

    class ExpandableViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val rootLayout: CardView = view.findViewById(R.id.root_layout)
        val details: RecyclerView = view.findViewById(R.id.recycler_item)
        val tvBinNumber: TextView = view.findViewById(R.id.number_card)
        val tvBankName:TextView = view.findViewById(R.id.bank_name)
        val ibDelete:ImageButton = view.findViewById(R.id.delete)

    }
////    val swipeToDeleteCallback = object : SwipeToDeleteCallback(){
////        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
////            val actualPosition = viewHolder.adapterPosition
////            items.removeAt(actualPosition)
////            notifyItemRemoved(actualPosition)
////        }
////    }
//
//    val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)


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
            ibDelete.setOnClickListener {
                //TODO add delete
                val actualPosition = holder.adapterPosition
                items.removeAt(actualPosition)
                notifyItemRemoved(actualPosition)
                notifyItemRangeChanged(actualPosition,items.size)
                listener.delete(item)


            }
            itemView.setOnClickListener {
                Log.i("EX_onBVH", item.nameBank!!)
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
                details.adapter = NestedAdapter(item) {nestedClickListener(it)}
            }
        }
    }

    override fun getItemCount() = items.size

    interface ActionClickListener{
        fun delete(id:BinEntities)
    }

}