package com.example.test_clear_architecture.base

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.test_clear_architecture.ui.main.MainActivity
import com.example.test_clear_architecture.base.progress_dialog.TestProgressDialog
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection

abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(),
    BaseActivityView {

    private lateinit var viewDataBinding: B
    private lateinit var viewModel: V
    private lateinit var progressDialog: TestProgressDialog

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    open fun getColorStatusBar(): Int? = null

    private var unBinder: Unbinder? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        performBinding()

        unBinder = ButterKnife.bind(this)

        this.progressDialog = TestProgressDialog(this)

        getColorStatusBar()?.let { setStatusBarColor(it) }
    }


    private fun performBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = getViewModel()
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        unBinder?.unbind()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBarColor(color: Int) {
        // LOLLIPOP (21)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val statusColor = getString(color)
        window.statusBarColor = Color.parseColor(statusColor)
    }

    override fun showProgressDialog(isShow: Boolean) {
        if (isShow) {
            showProgress()
        } else {
            dismissProgress()
        }
    }

    private fun showProgress() {
        if (!progressDialog.isShowing) progressDialog.show()
    }

    private fun dismissProgress() {
        if (progressDialog.isShowing) progressDialog.dismiss()
    }


    fun showSnackBar(resId: Int) {
        Snackbar.make(viewDataBinding.root, resId, Snackbar.LENGTH_LONG).show()
    }

    fun showSnackBar(message: String) {
        Snackbar.make(viewDataBinding.root, message, Snackbar.LENGTH_LONG).show()
    }

    private fun startMainActivity() {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
        finish()
    }


}