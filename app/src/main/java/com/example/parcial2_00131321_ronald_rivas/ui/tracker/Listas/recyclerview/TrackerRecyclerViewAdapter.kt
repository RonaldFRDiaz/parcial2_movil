package com.example.parcial2_00131321_ronald_rivas.UI.tracker.listas.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.databinding.TrackerItemBinding

class TrackerRecyclerViewAdapter(
    private val clickListener: (trackermodel) -> Unit
) : RecyclerView.Adapter<TrackerRecyclerViewHolder>()  {
    private val trackers = ArrayList<trackermodel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackerRecyclerViewHolder {
        val binding = TrackerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackerRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return trackers.size
    }

    override fun onBindViewHolder(holder: TrackerRecyclerViewHolder, position: Int) {
        val tracker = trackers[position]
        holder.bind(tracker, clickListener)
    }

    fun setData(trackerList: List<trackermodel>) {
        trackers.clear()
        trackers.addAll(trackerList)
    }
}