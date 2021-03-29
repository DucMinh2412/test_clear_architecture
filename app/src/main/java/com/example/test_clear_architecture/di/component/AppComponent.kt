package com.example.test_clear_architecture.di.component

import com.example.test_clear_architecture.di.TestClearArchitecture
import com.example.test_clear_architecture.di.builder.ActivityBuilder
import com.example.test_clear_architecture.di.builder.FragmentBuilder
import com.example.test_clear_architecture.di.module.RepositoryModule
import com.example.test_clear_architecture.di.module.ApiModule
import com.example.test_clear_architecture.di.module.AppModule
import com.example.test_clear_architecture.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Duc Minh
 */

@Component(
    modules = [
        (AndroidInjectionModule::class),
        (ApiModule::class),
        (RepositoryModule::class),
        (AppModule::class),
        (ViewModelModule::class),
        (ActivityBuilder::class),
        (FragmentBuilder::class),
    ]
)

@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TestClearArchitecture): Builder

        fun build(): AppComponent
    }

    /*
     * This is our custom Application class
     * */
    fun inject(testClearArchitecture: TestClearArchitecture)
}