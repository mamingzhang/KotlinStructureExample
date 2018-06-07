package com.horsege.kotlinstructure.data.http.mapper

import com.horsege.kotlinstructure.data.http.movie.Movie
import com.horsege.kotlinstructure.domain.entity.MovieDomain

object MovieMapper {
    fun transform(movies: List<Movie>) = movies?.map {
        MovieDomain(it.title, it.year, it.images.medium)
    }
}