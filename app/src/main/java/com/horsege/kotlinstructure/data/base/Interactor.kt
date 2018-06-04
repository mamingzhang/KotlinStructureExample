package com.horsege.kotlinstructure.data.base

interface Interactor {
    operator fun invoke(): Event
}