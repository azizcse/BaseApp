package com.tsl.baseapp.ui.login

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.tsl.baseapp.R
import com.tsl.baseapp.data.model.response.UserResponseItem
import com.tsl.baseapp.databinding.UserItemLayoutBinding
import com.tsl.baseapp.ui.base.BaseAdapter
import com.tsl.baseapp.ui.base.BaseViewHolder

/**
 * @author md-azizul-islam
 * Created 10/22/24 at 3:30 PM
 */
class LoginAdapter(val context: Context) : BaseAdapter<UserResponseItem>() {

    override fun newViewHolder( parent: ViewGroup?, viewType: Int ): BaseViewHolder<UserResponseItem> {
        return UserListHV(inflate(parent!!, R.layout.user_item_layout))
    }

    inner class UserListHV(viewDataBinding: ViewDataBinding) : BaseViewHolder<UserResponseItem>(viewDataBinding) {
        private val binding = getViewBinding() as UserItemLayoutBinding

        override fun bind(item: UserResponseItem) {
            setOnClick(binding.root)
            binding.tvName.text = item.name
            binding.tvAddress.text = item.phone
        }

        override fun onClick(v: View?) {
            getItem(adapterPosition)?.let {item->
                v?.let { view ->
                    itemClickListener?.onItemClick(view, item)
                }
            }
        }
    }

    override fun isEqual(leftItem: UserResponseItem, rightItem: UserResponseItem): Boolean {
        return false
    }
}