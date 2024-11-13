package com.tsl.baseapp.ui.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.tsl.baseapp.data.model.response.UserItem
import com.tsl.baseapp.databinding.ActivityLoginBinding

import com.tsl.baseapp.ui.base.BaseActivity
import com.tsl.baseapp.ui.base.ItemClickListener
import com.tsl.baseapp.ui.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(),
    ItemClickListener<UserItem> {

    private lateinit var loginAdapter: LoginAdapter

    override val mViewModel: LoginViewModel by viewModels()

    override fun getViewBinding(): ActivityLoginBinding =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun startView() {
        loginAdapter = LoginAdapter(this)
        mViewBinding.rvUserList?.adapter = loginAdapter
        loginAdapter.addItems(mViewModel.getUserList())
        loginAdapter.setClickLisener(this)
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

    override fun onItemClick(view: View, item: UserItem) {
        Toast.makeText(this, item.name, Toast.LENGTH_LONG).show()
        mViewModel.getAllUsers()
       // startActivity(Intent(this, DashboardActivity::class.java))
    }

}