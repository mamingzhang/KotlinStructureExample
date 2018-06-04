package com.horsege.kotlinstructure.domain.repository

import com.horsege.kotlinstructure.domain.entity.MovieDomain

interface MovieRepository {
    fun getTopMovie(start: Int, count: Int): List<MovieDomain>
}