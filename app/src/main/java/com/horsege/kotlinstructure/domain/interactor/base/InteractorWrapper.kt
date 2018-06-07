package com.horsege.kotlinstructure.domain.interactor.base

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import org.greenrobot.eventbus.EventBus

class InteractorWrapper(val interactor: Interactor, priority: InteractorPriority, val eventBus: EventBus) :
        Job(Params(priority.value).requireNetwork()) {
    override fun onRun() {
        val event = interactor.invoke()
        eventBus.post(event)
    }

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int) = RetryConstraint.CANCEL

    override fun onAdded() = Unit

    override fun onCancel(cancelReason: Int, throwable: Throwable?) = Unit
}