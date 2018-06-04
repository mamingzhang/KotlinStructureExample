package com.horsege.kotlinstructure.data.base

import org.greenrobot.eventbus.EventBus

class CustomEventBus : EventBus(){
    companion object {
        fun getCustomEventBus(): EventBus {
            return getDefault();
        }
    }
}