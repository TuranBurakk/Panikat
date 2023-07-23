package com.infos.panikat.ui.homescreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.infos.panikat.base.BaseFragment
import com.infos.panikat.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) ,
    ICardClickListener {

    private val adapter by lazy { HomeAdapter(this) }
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        /*For created firebase architectural
         viewModel.pushData()*/


        viewModel.getData()
        viewModel.card.observe(viewLifecycleOwner){list->
            adapter.setData(list)
        }
    }

    override fun navigate(exercise:String) {
       when(exercise){
           "breath" -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToBreathingExerciseFragment())
           "calming" -> findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCalmingExerciseFragment())
       }
    }
}