package com.horsege.kotlinstructure.dagger

import com.horsege.kotlinstructure.data.http.HttpApiService
import com.horsege.kotlinstructure.data.http.movie.ServerMovieDataSet
import com.horsege.kotlinstructure.domain.repository.MovieRepository
import com.horsege.kotlinstructure.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(httpApiService: HttpApiService): MovieRepository
            = MovieRepositoryImpl(listOf(ServerMovieDataSet(httpApiService)))
}