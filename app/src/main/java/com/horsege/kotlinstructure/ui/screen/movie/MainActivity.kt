package com.horsege.kotlinstructure.ui.screen.movie

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.horsege.kotlinstructure.R
import com.horsege.kotlinstructure.dagger.AppComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MainActivityModule
import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.ui.activity.BaseActivity
import com.horsege.kotlinstructure.ui.adapter.MovieAdapter
import com.horsege.kotlinstructure.ui.presenter.MoviePresenter
import com.horsege.kotlinstructure.ui.view.MovieView
import horsege.com.supportdesiginexample.ui.avtivity.AnkoBaseActivity
import org.jetbrains.anko.longToast
import javax.inject.Inject

class MainActivity : AnkoBaseActivity<MovieLayout>(), MovieView {
    override val ui = MovieLayout()

    @Inject
    lateinit var presenter: MoviePresenter

    private lateinit var adapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = MovieAdapter { longToast(it.title) }
        ui.recyclerView.layoutManager = LinearLayoutManager(this)
        ui.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        ui.recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(MainActivityModule(this)).injectTo(this)
    }

    override fun showMovie(movies: List<MovieDomain>) {
        adapter.items = movies
    }
}
