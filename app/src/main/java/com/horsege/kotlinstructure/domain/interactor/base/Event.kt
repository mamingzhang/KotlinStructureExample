package com.horsege.kotlinstructure.domain.interactor.base

/**
 * EventBus通知实体
 */
abstract class Event(val code: Int = 0, val message: String = "")