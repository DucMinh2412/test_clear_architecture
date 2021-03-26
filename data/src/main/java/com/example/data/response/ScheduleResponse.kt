package com.example.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ScheduleResponse(

        @Expose
        @SerializedName("date")
        val date: Long,

        @Expose
        @SerializedName("doctor")
        val doctor: String,

        @Expose
        @SerializedName("hospital")
        val hospital: String,

        @Expose
        @SerializedName("name_schedule")
        val nameSchedule: String,

        @Expose
        @SerializedName("name_specialist_examination")
        val nameSpecialistExamination: String,
)