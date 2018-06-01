package com.horsege.kotlinstructure.data.http.entity

/**
 * 通用服务器响应实体
 */
data class ResponseWrapper<T>(var code: Int, var message: String, var data: T)