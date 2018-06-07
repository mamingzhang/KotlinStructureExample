package com.horsege.kotlinstructure.data.http.utils

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

object NetworkScheduler {
    fun <T> compose(): Observable.Transformer<T, T> {
        return Observable.Transformer {
            observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> composeCurrent(): Observable.Transformer<T, T> {
        return Observable.Transformer {
            observable -> observable.subscribeOn(Schedulers.immediate()).observeOn(Schedulers.immediate())
        }
    }
}
