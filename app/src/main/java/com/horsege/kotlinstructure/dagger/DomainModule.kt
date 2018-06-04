package com.horsege.kotlinstructure.dagger

import com.horsege.kotlinstructure.domain.interactor.GetMovieInteractor
import com.horsege.kotlinstructure.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGetMovieInteractor(movieRepository: MovieRepository): GetMovieInteractor = GetMovieInteractor(movieRepository)
}