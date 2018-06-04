package com.horsege.kotlinstructure.repository.dataset

import com.horsege.kotlinstructure.domain.entity.MovieDomain

interface MovieDataSet {
    fun requestTopMovie(start: Int, count: Int) : List<MovieDomain>
}