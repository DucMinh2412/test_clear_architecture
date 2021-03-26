package com.example.data.repository

import com.example.data.remote.ApiHelper
import com.example.data.response.ScheduleListResponse
import com.example.domain.repository.ScheduleRepository
import io.reactivex.Single
import javax.inject.Inject

class ScheduleRepositoryImp @Inject constructor(
    private val apiHelper: ApiHelper
) : ScheduleRepository {


    override fun getListSchedule(): Single<List<ScheduleListResponse>> {
        return apiHelper.getListSchedule()
    }
}