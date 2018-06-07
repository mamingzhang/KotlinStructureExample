package com.horsege.kotlinstructure.ui.screen.movie

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.horsege.kotlinstructure.R
import com.horsege.kotlinstructure.dagger.AppComponent
import com.horsege.kotlinstructure.dagger.subcomponent.main.MainActivityModule
import com.horsege.kotlinstructure.domain.entity.MovieDomain
import com.horsege.kotlinstructure.ui.activity.BaseActivity
import com.horsege.kotlinstructure.ui.adapter.MovieAdapter
import com.horsege.kotlinstructure.ui.presenter.MoviePresenter
import com.horsege.kotlinstructure.ui.view.MovieView
import kotlinx.android.synthetic.main.activity_movie_xml.*
import org.jetbrains.anko.longToast
import javax.inject.Inject

class MovieXMLActivity : BaseActivity(), MovieView {

    @Inject
    lateinit var presenter: MoviePresenter

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_xml)

        adapter = MovieAdapter { longToast(it.title) }
        swipe_target.layoutManager = LinearLayoutManager(this)
        swipe_target.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        swipe_target.adapter = adapter

        swipeToLoadLayout.setOnRefreshListener {
            longToast("OnRefresh")
        }

        swipeToLoadLayout.setOnLoadMoreListener {
            longToast("LoadMore")
        }

        swipe_target.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!swipe_target.canScrollVertically(1)) {
                        swipeToLoadLayout.isLoadingMore = true
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
        appComponent.plus(MainActivityModule(this)).injectTo(this)
    }

    override fun showMovie(movies: List<MovieDomain>) {
        adapter.items = movies
    }
}
