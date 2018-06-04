package com.horsege.kotlinstructure.dagger

import android.content.Context
import com.birbit.android.jobqueue.JobManager
import com.horsege.kotlinstructure.dagger.qualifier.ApplicationQualifier
import com.horsege.kotlinstructure.data.base.CustomEventBus
import com.horsege.kotlinstructure.data.base.CustomJobManager
import com.horsege.kotlinstructure.data.base.InteractorExecutorImpl
import com.horsege.kotlinstructure.data.http.HttpApiService
import com.horsege.kotlinstructure.data.http.HttpOkHttpClient
import com.horsege.kotlinstructure.data.http.HttpRetrofit
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
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

    @Provides
    @Singleton
    fun provideEventBus(): EventBus = CustomEventBus.getCustomEventBus()

    @Provides
    @Singleton
    fun provideJobManager(@ApplicationQualifier context: Context): JobManager = CustomJobManager.getJobManager(context)

    @Provides
    @Singleton
    fun provideInteractorExecutor(jobManager: JobManager, eventBus: EventBus) = InteractorExecutorImpl(jobManager, eventBus)
}