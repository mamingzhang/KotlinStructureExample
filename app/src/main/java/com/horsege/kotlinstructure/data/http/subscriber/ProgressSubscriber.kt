package com.horsege.kotlinstructure.data.http.subscriber

import android.content.Context

/**
 * TODO: 进度条请求封装，请求会弹出进度提示
 */
abstract class ProgressSubscriber<T>(private val context: Context) : UniversalSubscriber<T>(context) {
    override fun onCompleted() {
        super.onCompleted()
    }

    override fun onError(e: Throwable?) {
        super.onError(e)
    }
}