package com.tsl.baseapp.ui.base

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {
    private val mItemList: ArrayList<T> = arrayListOf()
    protected var itemClickListener: ItemClickListener<T>? = null

    override fun getItemCount(): Int {
        return mItemList.size
    }

    fun addItem(item: T) {
        mItemList.add(item)
        notifyItemInserted(mItemList.size - 1)
    }

    fun getItem(pos: Int): T? {
        if(mItemList.size == 0 || pos >= mItemList.size) return null
        return mItemList.get(pos)
    }

    fun addItems(itemList: List<T>) {
        mItemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun removeItem(t: T) {
        var index: Int = mItemList.indexOf(t);

        if (index < 0 || index >= mItemList.size) return

        mItemList.removeAt(index)
        notifyItemMoved(index, mItemList.size)
    }

    fun clear() {
        mItemList.clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<T> {
        return mItemList
    }

    fun addUniqueItems(itemList:List<T>){
        for (item : T in itemList){
            val exist = findItem(item)


            if(exist == null){
                addItem(item)
                Log.e("Adapter_item","Added")
            }else{
                updateItem(item)
                Log.e("Adapter_item","updated")
            }
        }
    }

    fun updateItem(i: T) {
        var item = findItem(i)
        if (item != null) {
            val index = mItemList.indexOf(item)
            mItemList.set(index, i)
            notifyItemChanged(index)
        }
    }

    fun findItem(item: T): T? {
        for (tItem in mItemList) {
            if (isEqual(item, tItem)) {
                return tItem
            }
        }
        return null
    }

    fun setClickLisener(listener: ItemClickListener<T>) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return newViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        var item: T? = getItem(position)
        holder.bind(item!!)
    }

    fun inflate(viewGroup: ViewGroup, item_layout: Int): ViewDataBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), item_layout, viewGroup, false)
    }

    abstract fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<T>

    abstract fun isEqual(leftItem: T, rightItem: T): Boolean
}