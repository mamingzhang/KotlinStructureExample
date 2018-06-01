package com.horsege.kotlinstructure.dagger.subcomponent.main

import com.horsege.kotlinstructure.MainActivity
import com.horsege.kotlinstructure.dagger.ActivityModule
import dagger.Module

@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {
}