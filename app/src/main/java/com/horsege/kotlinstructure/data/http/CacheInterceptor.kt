package com.horsege.kotlinstructure.data.http

import android.content.Context
import com.horsege.kotlinstructure.utils.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(private val context: Context) : Interceptor{
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain!!.request()

        val newBuilder = request.newBuilder()

        //无网络使用缓存
        if (!NetworkUtils.bNetworkAvaiable(context)) {
            newBuilder.cacheControl(CacheControl.FORCE_CACHE)
        }

        val newRequest = newBuilder.method(request.method(), request.body()).build()

        val response = chain!!.proceed(newRequest)

        //增加缓存
        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "max-age=" + 60 * 10)
                .build()
    }
}