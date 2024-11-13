package com.tsl.baseapp.ui.login


import android.util.Log
import androidx.lifecycle.viewModelScope
import com.tsl.baseapp.data.model.response.UserItem
import com.tsl.baseapp.network.repository.UserRepository
import com.tsl.baseapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :
    BaseViewModel() {
    fun getUserList(): List<UserItem> {
        val userList = ArrayList<UserItem>()
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        userList.add(
            UserItem(
                name = "TechnoNext ${System.currentTimeMillis()}",
                phone = "019${System.currentTimeMillis()}"
            )
        )
        return userList
    }

    fun getAllUsers() {
        viewModelScope.launch {
            val response = callApi { userRepository.getUserList() }
            Log.e("User_info","Third $response")
        }
    }
}