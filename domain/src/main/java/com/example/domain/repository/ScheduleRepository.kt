package com.example.domain.repository

import com.example.data.response.ScheduleListResponse
import com.example.data.response.ScheduleResponse
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader
import io.reactivex.Single

interface ScheduleRepository {

    fun getListSchedule(): Single<List<ScheduleListResponse>>
}