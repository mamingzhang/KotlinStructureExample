package com.horsege.kotlinstructure.data.http.entity

import android.content.Context
import android.support.annotation.StringRes
import com.horsege.kotlinstructure.R

enum class ApiErrorType(val code: Int, @param:StringRes private val msgId: Int) {

    INTERNAL_SERVER_ERROR(500, R.string.apierror_serviceerror),
    BAD_GATEWAY(502, R.string.apierror_serviceerror),
    NOT_FOUND(404, R.string.apierror_notfound),
    NETWORK_NOT_CONNECT(499, R.string.apierror_notnetwork),
    CONNECTION_TIMEOUT(408, R.string.apierror_timeout),
    UNEXPECTED_ERROR(700, R.string.unexpected_error);

    private val DEFAULT_CODE = 1

    fun getApiErrorModel(context: Context) : ApiErrorModel {
        return ApiErrorModel(DEFAULT_CODE, context.getString(msgId))
    }
}