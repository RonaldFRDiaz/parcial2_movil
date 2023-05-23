package com.example.parcial2_00131321_ronald_rivas.Repository

import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel

class trackerRepository(private val trackers: MutableList<trackermodel>) {

    fun getTrackers() = trackers

    // add a new movie to the list of movies dummyData.kt
    fun addTrackers(tracker: trackermodel) = trackers.add(tracker)


}