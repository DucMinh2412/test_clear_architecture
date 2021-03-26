package com.example.data.remote

import com.example.data.response.ScheduleListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("/v1/cb8475df")
    fun getListSchedule(): Single<List<ScheduleListResponse>>

}



