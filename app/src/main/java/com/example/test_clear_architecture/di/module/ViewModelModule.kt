package com.example.test_clear_architecture.di.module

import androidx.lifecycle.ViewModel
import com.example.test_clear_architecture.di.viewmodel.ViewModelKey
import com.example.test_clear_architecture.ui.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun binMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}