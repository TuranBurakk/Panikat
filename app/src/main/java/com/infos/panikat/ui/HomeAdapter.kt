package com.infos.panikat.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infos.panikat.data.cardData
import com.infos.panikat.databinding.CardRowBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.CardHolder>() {
    private var list = emptyList<cardData>()

    class CardHolder(val binding : CardRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = CardRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

    }

    override fun getItemCount() = list.size

    fun setData(newList: List<cardData>) {
        list = newList
        notifyDataSetChanged()
    }
}