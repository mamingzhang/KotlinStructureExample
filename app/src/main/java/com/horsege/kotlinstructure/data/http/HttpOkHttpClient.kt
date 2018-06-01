package com.horsege.kotlinstructure.data.http

import android.content.Context
import com.facebook.stetho.okhttp3.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 *
 */
class HttpOkHttpClient(private val appContext: Context) {

    fun createOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.networkInterceptors().add(StethoInterceptor())
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)

        //设置缓存
        okHttpClientBuilder.cache(Cache(appContext.cacheDir, 1024 * 1024 * 10))
        okHttpClientBuilder.addNetworkInterceptor(CacheInterceptor(appContext))

        //Log设置
        okHttpClientBuilder.addInterceptor(HttpLoggingInterceptor()
                .apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE })

        return okHttpClientBuilder.build()
    }

}