package com.koshkin.android.testzba.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.testzba.CABApplication
import com.koshkin.android.testzba.R
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.databinding.FragmentSecondExpandableBinding
import com.koshkin.android.testzba.presentation.ui.adapters.ExpandableAdapter
import com.koshkin.android.testzba.presentation.ui.adapters.SwipeToDeleteCallback

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var expAdapter:ExpandableAdapter
    private var _binding: FragmentSecondExpandableBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val binViewModel : BinViewModel by viewModels{
        Log.i("KEK2",requireActivity().application.toString())
        BinViewModel.BinViewModelFactory(
            ((requireActivity().application) as CABApplication).deleteBinCardUseCase,
            ((requireActivity().application) as CABApplication).getRemoteBinUseCase,
            ((requireActivity().application) as CABApplication).getSavedBinsUseCase,
            ((requireActivity().application) as CABApplication).savedBinsUseCase,
            ((requireActivity().application) as CABApplication).binEntityMapperPr
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        expAdapter = ExpandableAdapter(requireContext(),binViewModel.arrayItem,{ },object: ExpandableAdapter.ActionClickListener{
            override fun delete(id: BinEntities) {
                binViewModel.deleteBin(id)
            }

        })

      //  binViewModel.getBinHistory()


//        expAdapter = ExpandableAdapter(requireContext(),binViewModel.binsDb,{ })
   //     Log.i("SF_onCR",binViewModel.binsDb[0].nameBank.toString())
    }

//    private fun getItems() = listOf(
//
//    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = inflater.inflate(R.layout.fragment_second_expandable,container,false)
        _binding = FragmentSecondExpandableBinding.inflate(inflater, container, false)

//        val recyclerView:RecyclerView = view.findViewById(R.id.recycler_expandable)
//        recyclerView.adapter = ExpandableAdapter(requireContext(),binViewModel.binsDb,{ })
     //   _binding!!.recyclerExpandable.adapter =ExpandableAdapter(requireContext(),binViewModel.arrayItem,{ })
        _binding!!.recyclerExpandable.adapter = expAdapter

        val swipeToDeleteCallback = object :SwipeToDeleteCallback(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val actualPosition = viewHolder.adapterPosition
                binViewModel.arrayItem.removeAt(actualPosition)
                binding.recyclerExpandable.adapter?.notifyItemRemoved(actualPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerExpandable)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.recyclerExpandable.adapter =ExpandableAdapter(requireContext(),binViewModel.binsDb,{ })

//        binding.recyclerExpandable.apply {
//            layoutManager =LinearLayoutManager(requireContext())
//        adapter=expAdapter
     //       Log.i("SF_onVCR",binViewModel.binsDb[0].nameBank.toString())
 //       }


            //        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }


        }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}