package com.horsege.kotlinstructure.dagger

import android.content.Context
import com.horsege.kotlinstructure.App
import com.horsege.kotlinstructure.dagger.qualifier.ApplicationQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): App = app

    @Provides
    @Singleton
    @ApplicationQualifier
    fun provideApplicationContext(): Context = app
}