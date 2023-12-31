package com.infos.panikat.ui.breathingexercisescreen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.infos.panikat.R
import com.infos.panikat.base.BaseFragment
import com.infos.panikat.databinding.FragmentBreathingExerciseBinding

class BreathingExerciseFragment :
    BaseFragment<FragmentBreathingExerciseBinding>(FragmentBreathingExerciseBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val seekBar = binding.breathingSeekBar
        seekBar.progress = 0
        var currentIndex = 0

        val breathingExerciseList = listOf(
             getString(R.string.breathing_control_text_1)
            ,getString(R.string.breathing_control_text_2)
            ,getString(R.string.breathing_control_text_3)
            ,getString(R.string.breathing_control_text_4)
            ,getString(R.string.breathing_control_text_5)
            ,getString(R.string.breathing_control_text_6))

        binding.breathingBackButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
            }
            val previousString = breathingExerciseList[currentIndex]
            binding.breathingDescTv.text = previousString
            seekBar.progress = currentIndex
        }

        binding.breathingForwardButton.setOnClickListener {
            if (currentIndex < breathingExerciseList.size - 1) {
                currentIndex++
                val nextString = breathingExerciseList[currentIndex]
                binding.breathingDescTv.text = nextString
                seekBar.progress = currentIndex
            } else {
                showCustomDialog(requireContext())

            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                currentIndex = seekBar.progress
                val currentString = breathingExerciseList[currentIndex]
                binding.breathingDescTv.text = currentString
            }
        })
    }

    @SuppressLint("ResourceAsColor")
    private fun showCustomDialog(context: Context){
        val builder = AlertDialog.Builder(context)
        val customView = LayoutInflater.from(context).inflate(R.layout.layout_custom_dialog_breathing,null)
        builder.setView(customView)
        val dialog= builder.create()

        val btnYes = customView.findViewById<Button>(R.id.lets_start_btn)
        val btnClose = customView.findViewById<ImageButton>(R.id.close_btn)

        btnYes.setOnClickListener{
            findNavController().navigate(BreathingExerciseFragmentDirections.actionBreathingExerciseFragmentToCalmingExerciseFragment())
            dialog.dismiss()
        }
        btnClose.setOnClickListener{
            dialog.dismiss()
        }

        dialog.show()
    }

}
