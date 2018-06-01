package com.horsege.kotlinstructure.dagger

import android.content.Context
import com.horsege.kotlinstructure.dagger.qualifier.ApplicationQualifier
import com.horsege.kotlinstructure.data.http.HttpApiService
import com.horsege.kotlinstructure.data.http.HttpOkHttpClient
import com.horsege.kotlinstructure.data.http.HttpRetrofit
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationQualifier context: Context): OkHttpClient {
        return HttpOkHttpClient(context).createOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideRetorfit(okHttpClient: OkHttpClient): Retrofit = HttpRetrofit.getApiRetrofit(okHttpClient)

    @Provides
    @Singleton
    fun provideApiService(retorfit: Retrofit): HttpApiService = retorfit.create(HttpApiService::class.java)
}