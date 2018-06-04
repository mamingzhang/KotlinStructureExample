package com.horsege.kotlinstructure

import android.os.Bundle
import com.horsege.kotlinstructure.dagger.AppComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MainActivityModule
import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.ui.activity.BaseActivity
import com.horsege.kotlinstructure.ui.presenter.MoviePresenter
import com.horsege.kotlinstructure.ui.view.MovieView
import javax.inject.Inject

class MainActivity : BaseActivity(), MovieView {

    @Inject
    lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(MainActivityModule(this)).injectTo(this)
    }

    override fun showMovie(movies: List<MovieDomain>) {
    }
}
