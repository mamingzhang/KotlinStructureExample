package com.horsege.kotlinstructure.ui.screen.movie

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.horsege.kotlinstructure.dagger.AppComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MovieActivityModule
import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.ui.adapter.MovieAdapter
import com.horsege.kotlinstructure.ui.presenter.MoviePresenter
import com.horsege.kotlinstructure.ui.view.MovieView
import horsege.com.supportdesiginexample.ui.avtivity.AnkoBaseActivity
import org.jetbrains.anko.longToast
import javax.inject.Inject

class MovieActivity : AnkoBaseActivity<MovieLayout>(), MovieView {
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

        ui.swipeToLoadLayout.inflate()
        ui.swipeToLoadLayout.requestLayout()

        ui.googleCircleHookLoadMoreFooterView.inflate()
        ui.googleCircleHookLoadMoreFooterView.requestLayout()

        ui.googleCircleHookRefreshHeaderView.inflate()
        ui.googleCircleHookRefreshHeaderView.requestLayout()

        ui.swipeToLoadLayout.setOnRefreshListener {
            longToast("OnRefresh")
        }

        ui.swipeToLoadLayout.setOnLoadMoreListener {
            longToast("LoadMore")
        }

        ui.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!ui.recyclerView.canScrollVertically(1)) {
                        ui.swipeToLoadLayout.isLoadingMore = true
                    }
                }
            }
        })
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
        appComponent.plus(MovieActivityModule(this)).injectTo(this)
    }

    override fun showMovie(movies: List<MovieDomain>) {
        adapter.items = movies
    }
}
