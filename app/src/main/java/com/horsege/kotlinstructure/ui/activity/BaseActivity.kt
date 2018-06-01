package com.horsege.kotlinstructure.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.horsege.kotlinstructure.App
import com.horsege.kotlinstructure.dagger.AppComponent

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(App.appComponent)
    }

    /**
     * 注入依赖，如果不需要注意，可以不实现
     */
    protected open fun injectDependencies(appComponent: AppComponent) {

    }
}