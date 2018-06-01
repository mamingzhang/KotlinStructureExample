package com.horsege.kotlinstructure

import android.os.Bundle
import com.horsege.kotlinstructure.dagger.AppComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MainActivityModule
import com.horsege.kotlinstructure.ui.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(MainActivityModule(this)).injectTo(this)
    }
}
