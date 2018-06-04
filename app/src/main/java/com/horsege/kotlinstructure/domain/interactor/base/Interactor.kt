package com.horsege.kotlinstructure.domain.interactor.base

interface Interactor {
    operator fun invoke(): Event
}