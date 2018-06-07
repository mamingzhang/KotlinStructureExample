package com.horsege.kotlinstructure.data.http

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CustomResponseConvertyFactory private constructor(private val gson: Gson) : Converter.Factory() {
    companion object {
        /**
         * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
         * decoding from JSON (when no charset is specified by a header) will use UTF-8.
         */
        fun create(): CustomResponseConvertyFactory {
            return create(HttpCustomGson.createGson())
        }

        /**
         * Create an instance using {@code gson} for conversion. Encoding to JSON and
         * decoding from JSON (when no charset is specified by a header) will use UTF-8.
         */
        fun create(gson: Gson): CustomResponseConvertyFactory {
            return CustomResponseConvertyFactory(gson)
        }

    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *> {
        return CustomGsonResponseBodyConverter<Any>(gson, type!!)
    }
}