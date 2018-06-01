package com.horsege.kotlinstructure.data.http

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * 创建自定义Gson解析器
 */
object HttpCustomGson {
    fun createGson(): Gson {
        return GsonBuilder()
                //过滤器，根据需要过滤掉需要解析的类型
                .setExclusionStrategies(object : ExclusionStrategy {
                    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                        return false
                    }

                    override fun shouldSkipField(f: FieldAttributes?): Boolean {
                        return false
                    }
                })
                //注册自定义解析器
//                    .registerTypeAdapter()
                .create()
    }
}