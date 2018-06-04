package com.horsege.kotlinstructure.ui.presenter

import android.support.annotation.MainThread
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

    override fun onResume() {
        super.onResume()
        getMovieInteractor.count = 20
        interactorExecutor.execute(getMovieInteractor)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(movieEvent: MovieEvent) {
        view.showMovie(movieEvent.movies)
    }
}