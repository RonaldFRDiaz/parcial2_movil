package com.example.parcial2_00131321_ronald_rivas.Repository

import com.example.parcial2_00131321_ronald_rivas.data.model.trackermodel

class trackerRepository(private val trackers: MutableList<trackermodel>) {

    fun getTrackers() = trackers
    fun addTrackers(trackerPa: trackermodel) = trackers.add(trackerPa)
}