package com.example.test_clear_architecture.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.test_clear_architecture.BR
import com.example.test_clear_architecture.R
import com.example.test_clear_architecture.base.BaseActivity
import com.example.test_clear_architecture.databinding.ActivityMainBinding
import com.example.test_clear_architecture.di.viewmodel.ViewModelFactory
import com.example.test_clear_architecture.ui.MainActivityViewModel
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    @Inject
    internal lateinit var factory: ViewModelFactory

    private lateinit var mainActivityViewModel:MainActivityViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): MainActivityViewModel {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        return mainActivityViewModel
    }

    override fun getBindingVariable(): Int = BR.mainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel.getListSchedule()

    }


}