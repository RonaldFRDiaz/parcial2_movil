package com.example.parcial2_00131321_ronald_rivas.UI.tracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial2_00131321_ronald_rivas.trackerRA
import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel
import com.example.parcial2_00131321_ronald_rivas.Repository.trackerRepository

class TrackerViewModel(private val repository: trackerRepository) : ViewModel() {
    var name = MutableLiveData("")
    var category = MutableLiveData("")


    fun getTracker() = repository.getTrackers()

    private fun addTrackers(tracker: trackermodel) = repository.addTrackers(tracker)

    fun createtracker() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val tracker = trackermodel(
            name.value!!,
            category.value!!,

        )

        addTrackers(tracker)
        clearData()

        status.value = TRACKER_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        category.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedtracker(tracker: trackermodel) {
        name.value = tracker.name
        category.value = tracker.category
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as trackerRA
                TrackerViewModel(app.trackersRepository)
            }
        }

        const val TRACKER_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

}