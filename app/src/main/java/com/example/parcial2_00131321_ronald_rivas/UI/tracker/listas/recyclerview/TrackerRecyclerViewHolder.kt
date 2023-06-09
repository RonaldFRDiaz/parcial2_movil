package com.example.parcial2_00131321_ronald_rivas.UI.tracker.listas.recyclerview


import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.databinding.TrackerItemBinding

class TrackerRecyclerViewHolder(private val binding: TrackerItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(tracker: trackermodel, clickListener: (trackermodel) -> Unit) {
        binding.nameEditText.text = tracker.name
        binding.categoryEditText.text = tracker.category

        binding.trackerItemCardView.setOnClickListener {
            clickListener(tracker)
        }
    }
}