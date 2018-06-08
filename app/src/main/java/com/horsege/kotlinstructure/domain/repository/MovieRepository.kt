package com.horsege.kotlinstructure.domain.repository

import com.horsege.kotlinstructure.domain.interactor.event.MovieEvent

interface MovieRepository {
    fun getTopMovie(start: Int, count: Int): MovieEvent
}