package com.horsege.kotlinstructure.domain.interactor.base

/**
 * EventBus通知实体
 */
abstract class Event(var code: Int = 0, var message: String = "")