package com.example.parcial2_00131321_ronald_rivas

import android.app.Application
import com.example.parcial2_00131321_ronald_rivas.Repository.trackerRepository
import com.example.parcial2_00131321_ronald_rivas.data.tracker



class TrackerRA: Application(){
    val trackersRepository: trackerRepository by lazy {
        trackerRepository(tracker)
    }
}