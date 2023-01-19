package com.koshkin.android.testzba.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.koshkin.android.testzba.CABApplication
import com.koshkin.android.testzba.R
import com.koshkin.android.testzba.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val binViewModel : BinViewModel by viewModels{
        Log.i("KEK",requireActivity().application.toString())
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
        binViewModel.getBinV(45717360)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}