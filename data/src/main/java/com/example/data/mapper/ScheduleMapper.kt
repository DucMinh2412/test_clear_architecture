package com.example.data.mapper
import com.example.data.response.ScheduleResponse
import com.example.domain.model.Schedule
import javax.inject.Inject

class ScheduleMapper @Inject constructor() {

    fun map(responseList: List<ScheduleResponse>): List<Schedule> {
        return responseList.map { map(it) }
    }

    fun map(response: ScheduleResponse): Schedule {
        return Schedule(
            date = response.date,
            doctor = response.doctor,
            hospital = response.hospital,
            nameSchedule = response.nameSchedule,
            nameSpecialistExamination = response.nameSpecialistExamination
        )
    }

}