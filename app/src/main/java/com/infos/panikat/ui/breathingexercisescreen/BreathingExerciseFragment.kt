package com.infos.panikat.ui.breathingexercisescreen

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.infos.panikat.base.BaseFragment
import com.infos.panikat.databinding.FragmentBreathingExerciseBinding

class BreathingExerciseFragment :
    BaseFragment<FragmentBreathingExerciseBinding>(FragmentBreathingExerciseBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val seekBar = binding.breathingSeekBar
        seekBar.progress = 0
        var currentIndex = 0

        val breathingExerciseList = listOf("Yazı 1", "Yazı 2", "Yazı 3", "Yazı 4", "Yazı 5","Yazı 6")

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
                // Son öğeye ulaşıldığında yapılacak işlemler burada olabilir.
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
}
