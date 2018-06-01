package com.horsege.kotlinstructure.data.http

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import java.lang.reflect.Type

/**
 *
 */
class CustomGsonResponseBodyConverter<T>(private val gson: Gson, private val type: Type) : Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody?): T {
        val response = value?.string()
        return gson.fromJson(response, type)
    }
}