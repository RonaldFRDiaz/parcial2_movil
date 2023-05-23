package com.example.parcial2_00131321_ronald_rivas.UI.tracker


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcial2_00131321_ronald_rivas.R
import com.example.parcial2_00131321_ronald_rivas.databinding.FragmentTrackerBinding
import com.example.parcial2_00131321_ronald_rivas.UI.tracker.viewmodel.trackerviewmodel

class TrackerFragment : Fragment() {

    private val trackerviewmodel: trackerviewmodel by activityViewModels {
        trackerviewmodel.Factory
    }

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

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = trackerviewmodel
    }

}