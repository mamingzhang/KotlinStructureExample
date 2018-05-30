package com.horsege.kotlinstructure.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
}