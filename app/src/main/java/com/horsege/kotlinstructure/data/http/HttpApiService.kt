package com.horsege.kotlinstructure.data.http

import com.horsege.kotlinstructure.data.http.movie.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Http请求方法
 */
interface HttpApiService {
    @GET("top250")
    fun getTopMovie(@Query("start") start: Int, @Query("count") count: Int): Observable<MovieResult>
}