package com.tsl.baseapp.ui.login

import androidx.activity.viewModels
import com.tsl.baseapp.databinding.ActivityLoginBinding

import com.tsl.baseapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override val mViewModel: LoginViewModel by viewModels()

    override fun getViewBinding(): ActivityLoginBinding =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun setActionBarTitle(title: String?) {

    }

    override fun setActionBar() {

    }

    override fun hideActionBar() {

    }

    override fun onBackPressListener() {

    }

}