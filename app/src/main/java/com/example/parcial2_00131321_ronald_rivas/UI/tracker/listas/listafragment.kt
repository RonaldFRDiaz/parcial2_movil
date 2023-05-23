package com.example.parcial2_00131321_ronald_rivas.UI.tracker.listas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial2_00131321_ronald_rivas.R
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.databinding.FragmentTrackerBinding
import com.example.parcial2_00131321_ronald_rivas.UI.tracker.listas.recyclerview.TrackerRecyclerViewAdapter
import com.example.parcial2_00131321_ronald_rivas.UI.tracker.viewmodel.TrackerViewModel

class BillboardFragment : Fragment() {

    private val movieViewModel: TrackerViewModel by activityViewModels {
        TrackerViewModel.Factory
    }

    private lateinit var adapter: TrackerRecyclerViewAdapter

    private lateinit var binding: FragmentTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewTracker.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = TrackerRecyclerViewAdapter { selectedTracker ->
            showSelectedItem(selectedTracker)
        }

        binding.RecyclerView.adapter = adapter
        displayMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayMovies() {
        adapter.setData(movieViewModel.getTracker())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(movie: trackermodel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

}