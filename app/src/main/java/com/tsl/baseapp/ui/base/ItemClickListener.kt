package com.techfort.taakri.ui.base

import android.view.View

interface ItemClickListener<T> {
    fun onItemClick(view: View, item: T)
}