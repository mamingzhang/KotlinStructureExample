package com.horsege.kotlinstructure.dagger

import com.horsege.kotlinstructure.dagger.subcomponent.main.MainActivityComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MainActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
    fun plus(module: MainActivityModule): MainActivityComponent
}