package com.horsege.kotlinstructure.data.http.movie

import android.content.Context
import com.horsege.kotlinstructure.data.http.HttpApiService
import com.horsege.kotlinstructure.data.http.entity.ApiErrorModel
import com.horsege.kotlinstructure.data.http.mapper.MovieMapper
import com.horsege.kotlinstructure.data.http.subscriber.OrdinarySubscriber
import com.horsege.kotlinstructure.data.http.utils.NetworkScheduler
import com.horsege.kotlinstructure.domain.interactor.event.MovieEvent
import com.horsege.kotlinstructure.repository.dataset.MovieDataSet

class ServerMovieDataSet(private val context: Context, private val httpApiService: HttpApiService) : MovieDataSet{
    override fun requestTopMovie(start: Int, count: Int): MovieEvent {
        val movieEvent = MovieEvent(emptyList())

        httpApiService.getTopMovie(start, count).compose(NetworkScheduler.composeCurrent())
                .subscribe(object : OrdinarySubscriber<MovieResult>(context) {
                    override fun success(data: MovieResult) {
                        movieEvent.movies = MovieMapper.transform(data.subjects)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        movieEvent.code = statusCode
                        movieEvent.message = apiErrorModel.message
                    }

                })

        return movieEvent
    }
}