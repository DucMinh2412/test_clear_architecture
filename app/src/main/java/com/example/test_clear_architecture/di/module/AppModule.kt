package com.example.test_clear_architecture.di.module

import com.example.domain.repository.ScheduleRepository
import com.example.domain.usecase.ScheduleUseCase
import com.example.test_clear_architecture.di.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider()

}