package com.horsege.kotlinstructure.ui.view

import com.horsege.kotlinstructure.domain.entity.MovieDomain

interface MovieView {
    fun onRefreshFinished(movies: List<MovieDomain>)

    fun onLoadMoreFinished(movies: List<MovieDomain>, bNoMore: Boolean)
}