package com.example.data.remote

import com.example.data.response.ScheduleResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ApiHelperImp @Inject constructor( private val api: API) : ApiHelper {

    override fun getListSchedule(): Single<List<ScheduleResponse>> {
        return api.getListSchedule()
    }
}