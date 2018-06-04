package com.horsege.kotlinstructure.data.http.movie

import javax.security.auth.Subject

data class Avatars(val small: String, val medium: String, val large: String)

data class Cast(val id: String, val name: String, val alt: String, val avatars: Avatars)

data class Movie(val id: String, val alt: String, val year: String, val title: String, val original_title: String,
                 val genres: List<String>, val cast: List<Cast>, val directors: List<Cast>, val images: Avatars)

data class MovieResult(val count: Int, val start: Int, val total: Int, val title: String, val subjects: List<Movie>)