package com.horsege.kotlinstructure.data.http

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *
 */
class HttpOkHttpClient(private val appContext: Context) {

    fun createOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.networkInterceptors().add(StethoInterceptor())
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)

        return okHttpClientBuilder.build()
    }

}