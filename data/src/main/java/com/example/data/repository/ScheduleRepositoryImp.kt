package com.example.data.repository

import com.example.data.mapper.ScheduleMapper
import com.example.data.remote.ApiHelper
import com.example.domain.model.Schedule
import com.example.domain.repository.ScheduleRepository
import io.reactivex.Single
import javax.inject.Inject

class ScheduleRepositoryImp @Inject constructor(
    private val apiHelper: ApiHelper,
    private val scheduleMapper: ScheduleMapper
) : ScheduleRepository {


    override fun getListSchedule(): Single<List<Schedule>> {
        return apiHelper.getListSchedule().map { scheduleMapper.map(it) }
    }
}