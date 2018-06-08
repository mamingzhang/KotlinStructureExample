package com.horsege.kotlinstructure.domain.interactor.base

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.verbose

class InteractorWrapper(val interactor: Interactor, priority: InteractorPriority, val eventBus: EventBus) :
        Job(Params(priority.value).requireNetwork()), AnkoLogger {

    override fun onRun() {
        val event = interactor.invoke()
        eventBus.post(event)
    }

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        verbose("shouldReRunOnThrowable(${throwable.message})")
        return RetryConstraint.CANCEL
    }

    override fun onAdded() {
        verbose("onAdded")
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
        verbose("onCancel")
    }

}