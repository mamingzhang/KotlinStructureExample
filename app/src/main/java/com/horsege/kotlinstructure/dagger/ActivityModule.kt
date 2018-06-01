package com.horsege.kotlinstructure.dagger

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.horsege.kotlinstructure.dagger.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule(protected val activity: AppCompatActivity) {
    @Provides
    @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    fun provideActivityContext(): Context = activity.baseContext
}