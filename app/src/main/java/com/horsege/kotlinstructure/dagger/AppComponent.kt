package com.horsege.kotlinstructure.dagger

import com.horsege.kotlinstructure.dagger.subcomponent.main.MovieActivityComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MovieActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, RepositoryModule::class, DomainModule::class])
interface AppComponent {
    fun plus(module: MovieActivityModule): MovieActivityComponent
}