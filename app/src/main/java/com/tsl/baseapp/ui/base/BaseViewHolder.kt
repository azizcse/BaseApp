package com.tsl.baseapp.ui.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>constructor(private val viewDataBinding: ViewDataBinding):
    RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener  {

    abstract fun bind(item: T)


    fun setOnclick(vararg views: View) {
        for (view: View in views) {
            view.setOnClickListener(this)
        }
    }

    fun getViewBinding(): ViewDataBinding {
        return viewDataBinding
    }
}