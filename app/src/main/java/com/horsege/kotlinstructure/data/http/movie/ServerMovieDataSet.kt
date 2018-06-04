package com.horsege.kotlinstructure.data.http.movie

import com.horsege.kotlinstructure.data.http.HttpApiService
import com.horsege.kotlinstructure.data.http.mapper.MovieMapper
import com.horsege.kotlinstructure.data.http.utils.unWrapCall
import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.repository.dataset.MovieDataSet

class ServerMovieDataSet(private val httpApiService: HttpApiService) : MovieDataSet{
    override fun requestTopMovie(start: Int, count: Int): List<MovieDomain> {
        return httpApiService.getTopMovie(start, count).unWrapCall {
            MovieMapper.transform(subjects)
        } ?: emptyList()
    }
}