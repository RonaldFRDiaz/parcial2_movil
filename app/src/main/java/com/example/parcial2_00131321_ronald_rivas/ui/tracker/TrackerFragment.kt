package com.example.parcial2_00131321_ronald_rivas.UI.tracker


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcial2_00131321_ronald_rivas.databinding.FragmentTrackerBinding
import com.example.parcial2_00131321_ronald_rivas.UI.tracker.viewmodel.TrackerViewModel
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel

class TrackerFragment : Fragment() {

    private val trackerViewModel: trackermodel by activityViewModels {
        TrackerViewModel.Factory
    }

    private lateinit var binding: FragmentTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(View: View, savedInstanceState: Bundle?) {
        super.onViewCreated(View, savedInstanceState)
        binding.viewmodel = TrackerViewModel
    }

}