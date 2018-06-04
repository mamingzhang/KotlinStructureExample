package com.horsege.kotlinstructure.data.base

import com.birbit.android.jobqueue.JobManager
import org.greenrobot.eventbus.EventBus

class InteractorExecutorImpl(private val jobManager: JobManager, private val eventBus: EventBus) : InteractorExecutor {
    override fun execute(interactor: Interactor, priority: InteractorPriority) {
        jobManager.addJobInBackground(InteractorWrapper(interactor, priority, eventBus))
    }
}