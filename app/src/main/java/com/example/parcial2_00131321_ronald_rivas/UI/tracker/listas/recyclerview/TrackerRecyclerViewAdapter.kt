package com.example.parcial2_00131321_ronald_rivas.UI.tracker.listas.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.databinding.TrackerItemBinding

class TrackerRecyclerViewAdapter(
    private val clickListener: (trackermodel) -> Unit
) : RecyclerView.Adapter<TrackerRecyclerViewHolder>()  {
    private val movies = ArrayList<trackermodel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackerRecyclerViewHolder {
        val binding = TrackerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackerRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: TrackerRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<trackermodel>) {
        movies.clear()
        movies.addAll(moviesList)
    }
}