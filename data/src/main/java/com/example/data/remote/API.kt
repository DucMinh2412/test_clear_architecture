package com.example.data.remote

import com.example.data.response.ScheduleResponse
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("/v1/cb8475df")
    fun getListSchedule(): Single<List<ScheduleResponse>>

}



