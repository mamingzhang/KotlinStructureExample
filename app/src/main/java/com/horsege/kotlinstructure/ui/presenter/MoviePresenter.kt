package com.horsege.kotlinstructure.ui.presenter

import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.domain.interactor.GetMovieInteractor
import com.horsege.kotlinstructure.domain.interactor.base.InteractorExecutor
import com.horsege.kotlinstructure.domain.interactor.event.MovieEvent
import com.horsege.kotlinstructure.ui.view.MovieView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MoviePresenter(override val view: MovieView,
                     override val eventBus: EventBus,
                     private val getMovieInteractor: GetMovieInteractor,
                     private val interactorExecutor: InteractorExecutor) : Presenter<MovieView> {

    private var movies: MutableList<MovieDomain> = mutableListOf()

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(movieEvent: MovieEvent) {
        if (movies.size == 0) {
            movies.addAll(movieEvent.movies)
            view.onRefreshFinished(movieEvent.movies)
        } else {
            movies.addAll(movieEvent.movies)
            view.onLoadMoreFinished(movies, movieEvent.movies.size == 0)
        }
    }

    fun requestRefresh() {
        movies.clear()

        getMovieInteractor.count = 20
        interactorExecutor.execute(getMovieInteractor)
    }

    fun requestLoadMore() {
        if (movies.size == 0) {
            return
        }

        getMovieInteractor.start = movies.size
        getMovieInteractor.count = 20
        interactorExecutor.execute(getMovieInteractor)
    }
}