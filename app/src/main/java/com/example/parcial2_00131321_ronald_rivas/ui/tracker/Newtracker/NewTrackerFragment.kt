package com.example.parcial2_00131321_ronald_rivas.ui.tracker.Newtracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial2_00131321_ronald_rivas.databinding.FragmentNewTrackerBinding
import com.example.parcial2_00131321_ronald_rivas.ui.tracker.viewmodel.TrackerViewModel

class NewTrackerFragment : Fragment() {
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val carroViewModel: TrackerViewModel by activityViewModels {
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
        binding.viewmodel = carroViewModel
    }

    private fun observeStatus() {
        carroViewModel.status.observe(viewLifecycleOwner) {
                status -> when {
                status.equals(TrackerViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    carroViewModel.clearStatus()
                }
                status.equals(TrackerViewModel.TRACKER_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, carroViewModel.getTracker().toString())
                    carroViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }companion object {
        const val APP_TAG = "APP__TAG"
    }
}
