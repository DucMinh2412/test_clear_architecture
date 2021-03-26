package com.example.test_clear_architecture.base

interface BaseActivityView {
    fun showProgressDialog(isShow: Boolean)

    fun handleError(error: Throwable, option: Any? = null)

    fun showWarningDialog(msg: String)

    fun showWarningDialog(resId: Int)
}