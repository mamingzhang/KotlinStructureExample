package com.horsege.kotlinstructure.repository

import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.domain.repository.MovieRepository
import com.horsege.kotlinstructure.repository.dataset.MovieDataSet

class MovieRepositoryImpl(private val movieDataSets: List<MovieDataSet>) : MovieRepository {
    override fun getTopMovie(start: Int, count: Int): List<MovieDomain> = movieDataSets
            .map { it.requestTopMovie(start, count) }
            .firstOrNull { it != null } ?: emptyList()
}