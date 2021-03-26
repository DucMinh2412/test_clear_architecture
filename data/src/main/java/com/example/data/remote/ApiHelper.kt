package com.example.data.remote

import com.example.data.response.ScheduleListResponse
import io.reactivex.Single

interface ApiHelper {

    fun getListSchedule(): Single<List<ScheduleListResponse>>
}