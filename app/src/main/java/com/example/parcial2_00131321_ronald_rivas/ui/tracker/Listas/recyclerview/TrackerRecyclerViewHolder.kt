package com.example.parcial2_00131321_ronald_rivas.ui.tracker.Listas.recyclerview


import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.databinding.TrackerItemBinding
//hola
class TrackerRecyclerViewHolder(private val binding: TrackerItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(tracker: trackermodel, clickListener: (trackermodel) -> Unit) {
        binding.nameTextView.text = tracker.name
        binding.categoryTextView.text = tracker.category

        binding.trackerItemCardView.setOnClickListener {
            clickListener(tracker)
        }
    }
}