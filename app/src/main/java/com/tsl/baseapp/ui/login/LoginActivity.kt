package com.tsl.baseapp.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import com.tsl.baseapp.databinding.ActivityLoginBinding

import com.tsl.baseapp.R
import com.tsl.baseapp.ui.base.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override val mViewModel: LoginViewModel by viewModels()
    override fun getViewBinding(): ActivityLoginBinding =
        ActivityLoginBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
    }

    override fun setLanguageTexts() {
        TODO("Not yet implemented")
    }

    override fun setActionBarTitle(title: String?) {
        TODO("Not yet implemented")
    }

    override fun setActionBar() {
        TODO("Not yet implemented")
    }

    override fun hideActionBar() {
        TODO("Not yet implemented")
    }

    override fun onBackPressListener() {
        TODO("Not yet implemented")
    }

}