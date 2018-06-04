package com.horsege.kotlinstructure.ui.view

import com.horsege.kotlinstructure.domain.entity.MovieDomain

interface MovieView {
    fun showMovie(movies: List<MovieDomain>)
}