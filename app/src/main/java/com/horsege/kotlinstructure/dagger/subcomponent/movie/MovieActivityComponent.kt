package com.horsege.kotlinstructure.dagger.subcomponent.main

import com.horsege.kotlinstructure.ui.screen.movie.MovieActivity
import com.horsege.kotlinstructure.dagger.scope.ActivityScope
import com.horsege.kotlinstructure.ui.screen.movie.MovieXMLActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MovieActivityModule::class])
interface MovieActivityComponent {
    fun injectTo(activity: MovieActivity)
    fun injectTo(activity: MovieXMLActivity)
}