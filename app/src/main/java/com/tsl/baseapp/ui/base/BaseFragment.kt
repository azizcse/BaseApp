package com.tsl.baseapp.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {
    protected abstract val mViewModel: VM

    protected lateinit var mViewBinding: VB
    private lateinit var dialog: Dialog

    abstract fun getViewBinding(): VB
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = Dialog(requireContext())
        fm = requireActivity().supportFragmentManager
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = getViewBinding()
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }
    private fun setUpObservers() {
        mViewModel.showLoader.observe(viewLifecycleOwner) { it ->
            it.getContentIfNotHandled()?.let { isShow ->
                val activity = requireActivity()
                if (activity is BaseActivity<*, *>) {
                    //activity.manageLoader(isShow)
                }
            }
        }

        mViewModel.showMessage.observe(viewLifecycleOwner) { message ->
            message.getContentIfNotHandled()?.let {
                if (!it.isNullOrEmpty()) {
                    //showCustomDialog(message = it)
                }
            }
        }
    }




    override fun onPause() {
        super.onPause()
        val activity = requireActivity()
        if (activity is BaseActivity<*, *>) {
            //activity.cancelInactivityTimer()
        }
    }

    override fun onResume() {
        super.onResume()
        val activity = requireActivity()
        if (activity is BaseActivity<*, *>) {
            //activity.addMoneyBottomSheetDialog?.dismiss()
        }
    }


}