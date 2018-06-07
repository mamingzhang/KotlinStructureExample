package com.horsege.kotlinstructure.repository.dataset

import com.horsege.kotlinstructure.domain.interactor.event.MovieEvent

interface MovieDataSet {
    fun requestTopMovie(start: Int, count: Int) : MovieEvent
}