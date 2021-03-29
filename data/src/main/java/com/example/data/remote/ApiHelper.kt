package com.example.data.remote

import com.example.data.response.ScheduleResponse
import io.reactivex.Single

interface ApiHelper {

    fun getListSchedule(): Single<List<ScheduleResponse>>
}