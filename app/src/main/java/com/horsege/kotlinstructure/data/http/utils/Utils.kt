package com.horsege.kotlinstructure.data.http.utils

import retrofit2.Call


inline fun <T, U> Call<T>.unWrapCall(f: T.() -> U) = execute().body()?.f()