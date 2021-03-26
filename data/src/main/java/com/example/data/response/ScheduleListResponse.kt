package com.example.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ScheduleListResponse(

        @Expose
        @SerializedName("Schedules")
        val Schedules: ArrayList<ScheduleResponse>

)