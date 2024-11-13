package com.tsl.baseapp.ui.base


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsl.baseapp.data.base.BaseResponse
import com.tsl.baseapp.network.User
import com.tsl.baseapp.network.repository.TokenRepository
import com.tsl.baseapp.network.repository.UserRepository
import com.tsl.baseapp.utils.SingleLiveEvent
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

abstract class BaseViewModel: ViewModel() {
    private val _showLoader = MutableLiveData<SingleLiveEvent<Boolean>>()
    val showLoader: LiveData<SingleLiveEvent<Boolean>> = _showLoader

    private val _showMessage = MutableLiveData<SingleLiveEvent<String>>()
    val showMessage: LiveData<SingleLiveEvent<String>> = _showMessage

    private val _isLanguageUpdateNeeded = MutableLiveData<Boolean>()
    val isLanguageUpdateNeeded: LiveData<Boolean> = _isLanguageUpdateNeeded

    fun showLoader() {
        _showLoader.value = SingleLiveEvent(true)
    }

    fun hideLoader() {
        _showLoader.value = SingleLiveEvent(false)
    }

    suspend fun callApi(
        isShowMessage: Boolean = false,
        isShowErrorMessage: Boolean = true,
        isShowLoader: Boolean = true,
        skipHideLoading: Boolean = false,
        isShowGlobalErrorMessage: Boolean = true,
        api: suspend () -> Response<User>
    ): User? {
        try {
            if (isShowLoader)
                showLoader()

            delay(500)
            Log.e("User_info","API called")
            val response = api.invoke()

            if (isShowLoader && !skipHideLoading) {
                hideLoader()
            }
            var baseResponse = response.body();

            //Check Api response code here
            Log.e("User_info","First $baseResponse")
            val resposne = callAgain(api);
            return resposne.body()
        }catch (e: TimeoutCancellationException) {
            hideLoader()
            //hideGifLoader()
            //showMessage(timeOutErrorMessage)
            e.printStackTrace()
        } catch (e: CancellationException) {
            hideLoader()
            //hideGifLoader()
            e.printStackTrace()
        } catch (e: Exception) {
            hideLoader()
            //hideGifLoader()
            //showMessage(defaultErrorMessage)
            e.printStackTrace()
        }
        return null
    }

    suspend fun callAgain(nextApi:suspend ()->Response<User>):Response<User>{
       // val resoinse = userRepository.getUserList()
        val token = TokenRepository.getUsers()
        Log.e("User_info","Second : ${token.body()}")
        return nextApi.invoke()
    }

}