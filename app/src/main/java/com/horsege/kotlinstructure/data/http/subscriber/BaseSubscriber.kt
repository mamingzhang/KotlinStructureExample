package com.horsege.kotlinstructure.data.http.subscriber

import android.content.Context
import com.horsege.kotlinstructure.data.http.entity.ApiErrorModel
import com.horsege.kotlinstructure.data.http.entity.ApiErrorType
import com.horsege.kotlinstructure.data.http.entity.ResponseWrapper
import rx.Subscriber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseSubscriber<T>(private val context: Context) : Subscriber<ResponseWrapper<T>>() {

    abstract fun success(data: T)
    abstract fun failure(statusCode: Int, apiErrorModel: ApiErrorModel)

    private object Status {
        val SUCCESS = 0
    }

    override fun onNext(t: ResponseWrapper<T>) {
        if (t.code == Status.SUCCESS) {
            success(t.data)
            return
        }

        failure(t.code, ApiErrorModel(t.code, t.message))
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