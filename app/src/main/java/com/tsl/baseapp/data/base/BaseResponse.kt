package com.tsl.baseapp.data.base

class BaseResponse<T> {
    var responseMessage: String? = ""
    var responseCode: String? = ""
    var data: T? = null
}