package com.example.test_clear_architecture.ui

import android.util.Log.e
import androidx.databinding.ObservableArrayList
import com.example.domain.model.Schedule
import com.example.domain.usecase.ScheduleUseCase
import com.example.test_clear_architecture.base.BaseViewModel
import com.example.test_clear_architecture.ui.main.MainActivityView
import com.example.test_clear_architecture.utils.addTo
import java.util.*
import javax.inject.Inject


class MainActivityViewModel
@Inject internal constructor() : BaseViewModel<MainActivityView>() {

    val scheduleList = ObservableArrayList<Schedule>()

    fun getListSchedule() {
        scheduleUseCase.execute()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({ handleListScheduleSuccess(it) }, { e("abc", it.toString()) })
            .addTo(disposables)
    }

    private fun handleListScheduleSuccess(result: ScheduleUseCase.Result) {
        when (result) {
            is ScheduleUseCase.Result.Success -> {
                e("s", result.scheduleList.toString())
            }
            is ScheduleUseCase.Result.Failure -> {
                e("s", result.throwable.toString())
            }
        }
    }


}