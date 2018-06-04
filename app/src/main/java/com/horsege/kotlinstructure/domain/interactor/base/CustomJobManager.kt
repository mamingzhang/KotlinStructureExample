package com.horsege.kotlinstructure.domain.interactor.base

import android.content.Context
import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.config.Configuration

/**
 *
 */
class CustomJobManager private constructor(context: Context) : JobManager(getJobManagerConfiguration(context)) {
    companion object {
        private fun getJobManagerConfiguration(context: Context): Configuration {
            return Configuration.Builder(context)
                    .minConsumerCount(1)
                    .maxConsumerCount(3)
                    .loadFactor(3)
                    .consumerKeepAlive(120)
                    .build()
        }

        fun getJobManager(context: Context) : CustomJobManager {
            return CustomJobManager(context)
        }
    }
}