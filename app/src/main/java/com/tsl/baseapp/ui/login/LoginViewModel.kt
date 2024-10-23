package com.tsl.baseapp.ui.login

import com.tsl.baseapp.data.model.response.UserResponseItem
import com.tsl.baseapp.network.repository.UserRepository
import com.tsl.baseapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository): BaseViewModel() {
    fun getUserList(): List<UserResponseItem> {
        var userList = ArrayList<UserResponseItem>()
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        userList.add(UserResponseItem(name = "TechnoNext ${System.currentTimeMillis()}", phone = "019${System.currentTimeMillis()}"))
        return userList
    }

    /*private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }*/
}