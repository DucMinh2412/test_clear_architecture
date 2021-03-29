package com.example.domain.usecase

import com.example.domain.model.Schedule
import com.example.domain.repository.ScheduleRepository
import io.reactivex.Observable
import javax.inject.Inject

class ScheduleUseCase @Inject constructor(private val scheduleRepository: ScheduleRepository) {

    // sealed : phần mở rộng của enum class
    sealed class Result {
        object Loading : Result()
        data class Success(val scheduleList: List<Schedule>) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    fun execute(): Observable<Result> {
        return scheduleRepository.getListSchedule()
            .toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(it) }
            .startWith(Result.Loading)
    }
}