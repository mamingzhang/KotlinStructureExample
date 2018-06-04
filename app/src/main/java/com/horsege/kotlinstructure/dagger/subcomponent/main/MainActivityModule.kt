package com.horsege.kotlinstructure.dagger.subcomponent.main

import com.horsege.kotlinstructure.MainActivity
import com.horsege.kotlinstructure.dagger.ActivityModule
import com.horsege.kotlinstructure.dagger.scope.ActivityScope
import com.horsege.kotlinstructure.domain.interactor.GetMovieInteractor
import com.horsege.kotlinstructure.domain.interactor.base.InteractorExecutor
import com.horsege.kotlinstructure.ui.presenter.MoviePresenter
import com.horsege.kotlinstructure.ui.view.MovieView
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus

@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {
    @Provides
    @ActivityScope
    fun provideMovieView(): MovieView = activity as MovieView

    @Provides
    @ActivityScope
    fun provideMoviePresenter(view: MovieView, eventBus: EventBus, getMovieInteractor: GetMovieInteractor, interactorExecutor: InteractorExecutor)
            : MoviePresenter = MoviePresenter(view, eventBus, getMovieInteractor, interactorExecutor)
}