package com.horsege.kotlinstructure.domain.interactor.base

interface InteractorExecutor {
    fun execute(interactor: Interactor, priority: InteractorPriority = InteractorPriority.LOW)
}