package com.tsl.baseapp.ui.dashboard

import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tsl.baseapp.R
import com.tsl.baseapp.databinding.ActivityDashboardBinding
import com.tsl.baseapp.ui.base.BaseActivity

class DashboardActivity : BaseActivity<DashboardMainViewModel, ActivityDashboardBinding>() {
    override val mViewModel: DashboardMainViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView
    override fun getViewBinding(): ActivityDashboardBinding {
        return ActivityDashboardBinding.inflate(layoutInflater)
    }

    override fun startView() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.dashboardNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        bottomNav = mViewBinding.containerBottomNav.bottomNavigationView
        bottomNav.itemIconTintList = null
        setBottomNavSelectListener()
        navigationDrawerListeners()
    }

    private fun setBottomNavSelectListener() {
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> {
                    true
                }

                R.id.navMenu -> {
                    true
                }

                R.id.navChat -> {
                    true
                }

                R.id.navStat -> {
                    true
                }

                else -> {
                    true
                }
            }
        }
    }

    private fun navigationDrawerListeners(){
        mViewBinding.containerMenu.demoMenu.setOnClickListener {
            Toast.makeText(this,"Item clicked",Toast.LENGTH_LONG).show()
        }
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


    override fun stopView() {
        TODO("Not yet implemented")
    }
}