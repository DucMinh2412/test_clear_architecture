package com.example.test_clear_architecture.base.progress_dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.test_clear_architecture.R

class TestProgressDialog(context: Context) : Dialog(context, R.style.StyleDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_dialog_loading)
        setCancelable(false)
    }
}