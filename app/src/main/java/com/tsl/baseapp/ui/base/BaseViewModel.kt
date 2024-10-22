package com.tsl.baseapp.ui.base


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsl.baseapp.data.base.BaseResponse
import com.tsl.baseapp.utils.SingleLiveEvent
import kotlinx.coroutines.delay
import retrofit2.Response

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

    suspend fun <T> callApi(isShowMessage: Boolean = false,
                        isShowErrorMessage: Boolean = true,
                        isShowLoader: Boolean = true,
                        skipHideLoading: Boolean = false,
                        isShowGlobalErrorMessage: Boolean = true,
                        api: suspend () -> Response<BaseResponse<T>>
    ):BaseResponse<T>?{
        if (isShowLoader)
            showLoader()

        delay(500)
        val response = api.invoke()

        if (isShowLoader && !skipHideLoading) {
            hideLoader()
        }
        return response.body() as BaseResponse<T>
    }

}