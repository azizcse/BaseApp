package com.tsl.baseapp.ui.base

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {
    abstract val mViewModel: VM

    protected lateinit var mViewBinding: VB
    lateinit var dialog: Dialog
    private val logoutHandler = Handler(Looper.getMainLooper())
    abstract fun getViewBinding(): VB
    abstract fun setActionBarTitle(title: String?)
    abstract fun setActionBar()
    abstract fun hideActionBar()
    abstract fun onBackPressListener()


    /**
     * UI initialization and observer setup required
     */
    abstract fun startView()

    /**
     * Will be called when onDestroy method called
     */
    abstract fun stopView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = getViewBinding()
        setContentView(mViewBinding.root)
        dialog = Dialog(this)
        setUpObservers()
        startView()
    }

    private fun setUpObservers() {
        mViewModel.showLoader.observe(this) { it ->
            it.getContentIfNotHandled()?.let { isShow ->
                //manageLoader(isShow)
            }

        }

        mViewModel.showMessage.observe(this) { message ->
            message.getContentIfNotHandled()?.let {
                if (!it.isNullOrEmpty()) {
                    //showCustomDialog(message = it)
                }
            }
        }


        mViewModel.isLanguageUpdateNeeded.observe(this) { isUpdateNeeded ->
            if (isUpdateNeeded) {
                //setLanguageTexts()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (dialog.isShowing) dialog.dismiss()
        stopView()
    }

}