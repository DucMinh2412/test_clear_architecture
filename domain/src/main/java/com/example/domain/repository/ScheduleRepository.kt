package com.example.domain.repository

import com.example.domain.model.Schedule
import io.reactivex.Single

interface ScheduleRepository {

    fun getListSchedule(): Single<List<Schedule>>
}