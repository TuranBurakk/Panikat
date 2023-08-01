package com.infos.panikat.ui.calmingexercisescreen

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.infos.panikat.R
import com.infos.panikat.base.BaseFragment
import com.infos.panikat.databinding.FragmentCalmingExerciseBinding


class CalmingExerciseFragment : BaseFragment<FragmentCalmingExerciseBinding>(FragmentCalmingExerciseBinding::inflate) {

    private lateinit var  runnable: Runnable
    private var handler = Handler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.music)
        val seekBar = binding.seekBar
        seekBar.progress = 0
        binding.seekBar.max  = mediaPlayer.duration

        binding.floatingActionButton.setOnClickListener {
            if (!mediaPlayer.isPlaying && mediaPlayer.currentPosition < mediaPlayer.duration) {
                mediaPlayer.start()
                binding.floatingActionButton.setImageResource(R.drawable.ic_baseline_pause_24)
            } else if (mediaPlayer.currentPosition >= mediaPlayer.duration) {
                mediaPlayer.seekTo(0)
                mediaPlayer.start()
                binding.floatingActionButton.setImageResource(R.drawable.ic_baseline_pause_24)
            } else {
                mediaPlayer.pause()
                binding.floatingActionButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    mediaPlayer.seekTo(progress-1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        }
        )
        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
        mediaPlayer.setOnCompletionListener {
            binding.floatingActionButton.setImageResource(R.drawable.ic_baseline_replay_24)
            showCustomDialog(requireContext())
        }

    }

    @SuppressLint("ResourceAsColor")
    private fun showCustomDialog(context: Context){
        val builder = AlertDialog.Builder(context)
        val customView = LayoutInflater.from(context).inflate(R.layout.layout_custom_dialog_calming,null)
        builder.setView(customView)
        val dialog= builder.create()

        val btnYes = customView.findViewById<Button>(R.id.lets_start_btn)
        val btnClose = customView.findViewById<ImageButton>(R.id.close_btn)

        btnYes.setOnClickListener{
            findNavController().navigate(CalmingExerciseFragmentDirections.actionCalmingExerciseFragmentToBreathingExerciseFragment())
            dialog.dismiss()
        }
        btnClose.setOnClickListener{
            dialog.dismiss()
        }

        dialog.show()
    }



}