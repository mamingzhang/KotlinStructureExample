package com.horsege.kotlinstructure.domain.interactor

import com.horsege.kotlinstructure.domain.interactor.base.Event
import com.horsege.kotlinstructure.domain.interactor.base.Interactor
import com.horsege.kotlinstructure.domain.interactor.event.MovieEvent
import com.horsege.kotlinstructure.domain.repository.MovieRepository

class GetMovieInteractor(val movieRepository: MovieRepository): Interactor {
    var start: Int = 0
    var count: Int = 0

    override fun invoke(): Event {
        if (count == 0) throw IllegalArgumentException("count must not be zero")
        return movieRepository.getTopMovie(start, count)
    }
}