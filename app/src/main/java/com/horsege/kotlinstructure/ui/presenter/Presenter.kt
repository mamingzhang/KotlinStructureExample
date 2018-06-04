package com.horsege.kotlinstructure.ui.presenter

import org.greenrobot.eventbus.EventBus

interface Presenter<out T> {
    val view: T
    val eventBus: EventBus

    fun onResume() {
        eventBus.register(this)
    }

    fun onPause() {
        eventBus.unregister(this)
    }
}