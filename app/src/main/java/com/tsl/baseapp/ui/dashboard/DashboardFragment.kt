package com.tsl.baseapp.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.tsl.baseapp.databinding.FragmentDashboardBinding
import com.tsl.baseapp.ui.base.BaseFragment

class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding>() {
    override val mViewModel: DashboardViewModel by viewModels()

    override fun getViewBinding(): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(layoutInflater)
    }

    override fun startView() {
        initView()
        setClickListener();
    }

    private fun initView() {
        (activity as DashboardActivity).hideActionBar()
        mViewBinding.ltSwipe.setOnRefreshListener {
            mViewBinding.ltSwipe.isRefreshing = false
        }
    }

    private fun setClickListener() {
        mViewBinding.ivSideMenu.setOnClickListener {
            (activity as DashboardActivity).openSideMenu()
        }
    }

    override fun stopView() {

    }

}