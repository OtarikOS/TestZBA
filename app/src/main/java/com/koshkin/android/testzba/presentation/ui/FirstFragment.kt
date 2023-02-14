package com.koshkin.android.testzba.presentation.ui

import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.transition.Visibility
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
                    true -> LayoutUtils.crossFade(binding.progressBar,binding.textviewFirstInfo)
                    false -> LayoutUtils.crossFade(binding.textviewFirstInfo,binding.progressBar)
                }
            })
            binViewModel.bin.observe(viewLifecycleOwner, {
                var info:String = ""
                var increment :String =""
                if(binViewModel.bin.value?.scheme!=null) {increment="Scheme: ${binViewModel.bin.value?.scheme},"
                    info += increment}
                if(binViewModel.bin.value?.type!=null) {increment=" Type: ${binViewModel.bin.value?.type},"
                    info += increment}
                if(binViewModel.bin.value?.brand!=null) {increment=" Brand: ${binViewModel.bin.value?.brand},"
                    info += increment}
                if(binViewModel.bin.value?.prepaid!=null) {increment=" Prepaid: ${binViewModel.bin.value?.prepaid},"
                    info += increment}
                if(binViewModel.bin.value?.alpha2!=null) {increment=" Alpha2: ${binViewModel.bin.value?.alpha2},"
                    info += increment}
                if(binViewModel.bin.value?.nameCountry!=null) {increment=" Country: ${binViewModel.bin.value?.nameCountry},"
                    info += increment}
                if(binViewModel.bin.value?.emoji!=null) {increment=" Emoji: ${binViewModel.bin.value?.emoji},"
                    info += increment}
                if(binViewModel.bin.value?.currency!=null) {increment=" Currency: ${binViewModel.bin.value?.currency},"
                    info += increment}
                if(binViewModel.bin.value?.length!=null) {increment=" Length: ${binViewModel.bin.value?.length},"
                    info += increment}
                if(binViewModel.bin.value?.city!=null) {increment=" City: ${binViewModel.bin.value?.city},"
                    info += increment}

                binding.textviewFirstInfo.text =info
                Log.i("FF", binViewModel.bin.value?.scheme.toString())
                //          findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

                if(binViewModel.bin.value?.url!=null){
                    binding.textViewFirstUrl.text = binViewModel.bin.value?.url
                    Linkify.addLinks(binding.textViewFirstUrl,Linkify.WEB_URLS)
                }else{
                    binding.textViewFirstUrl.visibility =View.GONE
                }

                if(binViewModel.bin.value?.phone!=null){
                    binding.textView2FirstPhone.text = binViewModel.bin.value?.phone
                    Linkify.addLinks(binding.textView2FirstPhone,Linkify.PHONE_NUMBERS)
                }else {
                    binding.textView2FirstPhone.visibility = View.GONE
                }
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