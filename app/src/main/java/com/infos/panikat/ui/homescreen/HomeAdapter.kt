package com.infos.panikat.ui.homescreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infos.panikat.data.CardData
import com.infos.panikat.databinding.CardRowBinding

class HomeAdapter(
    private var clickListener: ICardClickListener
    ) : RecyclerView.Adapter<HomeAdapter.CardHolder>() {
    private var list = emptyList<CardData>()

    class CardHolder(val binding : CardRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = CardRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val card = list[position]
        holder.binding.apply {
            exerciseTitleText.text = card.title
            exerciseDescriptionText.text= card.desc
            estimatedTimeChip.text = card.time
        }
        holder.binding.card.setOnClickListener {
            card.exercise?.let { it1 -> clickListener.navigate(it1) }
        }
    }

    override fun getItemCount() = list.size

    fun setData(newList: List<CardData>) {
        list = newList
        notifyDataSetChanged()
    }
}