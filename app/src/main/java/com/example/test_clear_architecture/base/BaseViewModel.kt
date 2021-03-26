package com.example.test_clear_architecture.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_clear_architecture.utils.LoadingState
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference


abstract class BaseViewModel<V>() : ViewModel() {
    val disposables = CompositeDisposable()

    private var view: WeakReference<V>? = null

    private var loadingStateLiveData = MutableLiveData<LoadingState>(LoadingState.IDLE)

    fun getView(): V? {
        return this.view?.get()
    }

    fun setView(view: V) {
        this.view = WeakReference(view)
    }

    fun getLoadingState(): LiveData<LoadingState> = this.loadingStateLiveData

    fun setLoadingState(loadingState: LoadingState) {
        this.loadingStateLiveData.value = loadingState
    }
}