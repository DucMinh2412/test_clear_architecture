package com.example.test_clear_architecture.utils

sealed class LoadingState {

    open class ERROR(val e: Throwable? = null) : LoadingState()

    object IDLE : LoadingState()

    object LOADING : LoadingState()

    object FINISH : LoadingState()
}