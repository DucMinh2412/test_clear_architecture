package com.example.test_clear_architecture.di.builder

import com.example.test_clear_architecture.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
