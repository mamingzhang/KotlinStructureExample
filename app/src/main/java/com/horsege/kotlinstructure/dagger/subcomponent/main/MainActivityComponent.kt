package com.horsege.kotlinstructure.dagger.subcomponent.main

import com.horsege.kotlinstructure.ui.screen.movie.MainActivity
import com.horsege.kotlinstructure.dagger.scope.ActivityScope
import com.horsege.kotlinstructure.ui.screen.movie.MovieXMLActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun injectTo(activity: MainActivity)
    fun injectTo(activity: MovieXMLActivity)
}