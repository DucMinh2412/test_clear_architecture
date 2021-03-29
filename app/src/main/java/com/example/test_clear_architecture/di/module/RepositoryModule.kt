package com.example.test_clear_architecture.di.module

import com.example.data.mapper.ScheduleMapper
import com.example.data.remote.ApiHelper
import com.example.data.repository.ScheduleRepositoryImp
import com.example.domain.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideScheduleRepository(apiHelper: ApiHelper, scheduleMapper: ScheduleMapper)
            : ScheduleRepository {
        return ScheduleRepositoryImp(apiHelper, scheduleMapper)
    }
}