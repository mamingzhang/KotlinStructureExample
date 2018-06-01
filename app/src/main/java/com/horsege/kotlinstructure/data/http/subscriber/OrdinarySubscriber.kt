package com.horsege.kotlinstructure.data.http.subscriber

import android.content.Context
import com.horsege.kotlinstructure.data.http.entity.ApiErrorModel
import com.horsege.kotlinstructure.data.http.entity.ApiErrorType
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 非通用格式请求封装
 */
abstract class OrdinarySubscriber<T>(private val context: Context) : BaseSubscriber<T>() {

    abstract fun success(data: T)
    abstract fun failure(statusCode: Int, apiErrorModel: ApiErrorModel)

    override fun onNext(t: T) {
        success(t)
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
        val apiErrorType: ApiErrorType = when (e) {
            is UnknownHostException -> ApiErrorType.NETWORK_NOT_CONNECT
            is ConnectException -> ApiErrorType.NETWORK_NOT_CONNECT
            is SocketTimeoutException -> ApiErrorType.CONNECTION_TIMEOUT
            else -> ApiErrorType.UNEXPECTED_ERROR
        }

        failure(apiErrorType.code, apiErrorType.getApiErrorModel(context))
    }
}