package com.example.data.remote

import com.example.data.response.ScheduleListResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ApiHelperImp @Inject constructor( private val api: API) : ApiHelper {

    override fun getListSchedule(): Single<List<ScheduleListResponse>> {
        return api.getListSchedule()
    }
}