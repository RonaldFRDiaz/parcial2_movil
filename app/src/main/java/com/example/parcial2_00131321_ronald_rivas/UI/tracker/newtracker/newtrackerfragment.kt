package com.example.parcial2_00131321_ronald_rivas.UI.tracker.newtracker

import com.example.parcial2_00131321_ronald_rivas.Repository.trackerRepository

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial2_00131321_ronald_rivas.databinding.FragmentNewTrackerBinding
import com.example.parcial2_00131321_ronald_rivas.UI.tracker.viewmodel.trackerviewmodel

class NewTrackerFragment : Fragment() {

    private val TrackerViewModel: trackerRepository by activityViewModels {
        TrackerViewModel.Factory
    }

    private lateinit var binding: FragmentNewTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = trackerviewmodel
    }

    private fun observeStatus() {
        TrackerViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(TrackerViewModel.WRONG_INFORMATION) -> {
                    TrackerViewModel.clearStatus()
                }
                status.equals(TrackerViewModel.MOVIE_CREATED) -> {
                    TrackerViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}