package com.horsege.kotlinstructure.domain.interactor.event

import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.domain.interactor.base.Event

data class MovieEvent(var movies: List<MovieDomain>) : Event()