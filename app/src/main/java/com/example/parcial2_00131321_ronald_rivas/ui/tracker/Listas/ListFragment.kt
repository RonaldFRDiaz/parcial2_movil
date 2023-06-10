package com.example.parcial2_00131321_ronald_rivas.ui.tracker.Listas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial2_00131321_ronald_rivas.R
import com.example.parcial2_00131321_ronald_rivas.ui.tracker.Listas.recyclerview.TrackerRecyclerViewAdapter
import com.example.parcial2_00131321_ronald_rivas.ui.tracker.viewmodel.TrackerViewModel
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.databinding.FragmentTrackerBinding


class ListFragment : Fragment() {
    private val carroViewModel: TrackerViewModel by activityViewModels {
        TrackerViewModel.Factory
    }

    private lateinit var adapter: TrackerRecyclerViewAdapter

    private lateinit var binding: FragmentTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnLinkNewTracker.setOnClickListener {
            carroViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newTrackerFragment)
        }

    }

    private fun setRecyclerView(view: View){
        binding.recycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = TrackerRecyclerViewAdapter { selectedTracker ->
            showSelectedItem(selectedTracker)
        }

        binding.recyclerView.adapter = adapter
        displayTracker()
    }


    private fun displayTracker() {
        adapter.setData(carroViewModel.getTracker())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(tracker: trackermodel) {
        carroViewModel.setSelectedtracker(tracker)
        findNavController().navigate(R.id.action_billboardFragment_to_trackerFragment)
    }

}