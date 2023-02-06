package com.koshkin.android.testzba.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.koshkin.android.testzba.CABApplication
import com.koshkin.android.testzba.LayoutUtils
import com.koshkin.android.testzba.R
import com.koshkin.android.testzba.databinding.FragmentFirstBinding
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private  val binEntityPr:BinEntityPr? =null


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
            var id = binding.editText.text.toString()
Log.i("FF_get",id)
            binViewModel.getBinV(id.toIntOrNull()!!)

            binViewModel.dataLoading.observe(viewLifecycleOwner,{loading ->
                when(loading){
                    true -> LayoutUtils.crossFade(binding.progressBar,binding.textviewFirst)
                    false -> LayoutUtils.crossFade(binding.textviewFirst,binding.progressBar)
                }
            })
            binViewModel.bin.observe(viewLifecycleOwner, {

                binding.textviewFirst.text =
                    "shem = ${binViewModel.bin.value?.scheme}\nbrand = ${binEntityPr?.brand}"
                Log.i("FF", binViewModel.bin.value?.scheme.toString())
                //          findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            })

            binViewModel.error.observe(viewLifecycleOwner, {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.an_error_has_occurred, it),
                    Toast.LENGTH_LONG
                ).show()
                println(it)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}