package com.horsege.kotlinstructure.ui.screen.movie

import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout
import com.horsege.kotlinstructure.R
import com.horsege.kotlinstructure.ui.extensions.googleCircleHookLoadMoreFooterView
import com.horsege.kotlinstructure.ui.extensions.googleCircleHookRefreshHeaderView
import com.horsege.kotlinstructure.ui.extensions.googleCircleProgressView
import com.horsege.kotlinstructure.ui.extensions.swipeToLoadLayout
import com.horsege.kotlinstructure.ui.views.footer.GoogleCircleHookLoadMoreFooterView
import com.horsege.kotlinstructure.ui.views.header.GoogleCircleHookRefreshHeaderView
import horsege.com.supportdesiginexample.ui.avtivity.ActivityAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MovieLayout : ActivityAnkoComponent<MainActivity> {
    lateinit var recyclerView: RecyclerView
    lateinit var swipeToLoadLayout: SwipeToLoadLayout

    lateinit var googleCircleHookRefreshHeaderView: GoogleCircleHookRefreshHeaderView
    lateinit var googleCircleHookLoadMoreFooterView: GoogleCircleHookLoadMoreFooterView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        coordinatorLayout {
            appBarLayout {
                themedToolbar(R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {
                    backgroundColor = R.color.colorPrimary
                    textView("Movie")
                }.lparams(width = matchParent) {
                    scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or
                            AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                }
            }.lparams(width = matchParent)

            swipeToLoadLayout = swipeToLoadLayout {
                setDefaultToLoadingMoreScrollingDuration(500)
                setLoadMoreFinalDragOffset(dimen(R.dimen.load_more_final_offset_google))
                setLoadMoreTriggerOffset(dimen(R.dimen.load_more_trigger_offset_google))
                setRefreshFinalDragOffset(dimen(R.dimen.refresh_final_offset_google))
                setRefreshTriggerOffset(dimen(R.dimen.refresh_trigger_offset_google))
                setLoadMoreCompleteDelayDuration(0)
                setSwipeStyle(SwipeToLoadLayout.STYLE.ABOVE)

                googleCircleHookRefreshHeaderView = googleCircleHookRefreshHeaderView {
                    id = R.id.swipe_refresh_header
                    backgroundColor = Color.TRANSPARENT

                    googleCircleProgressView(R.style.GoogleCircleProgressViewStyle) {
                        id = R.id.googleProgress

                    }.lparams(width = dip(40), height = dip(40)) {
                        gravity = Gravity.CENTER
                    }

                }.lparams(width = matchParent, height = dip(100))

                recyclerView = recyclerView {
                    id = R.id.swipe_target
                }.lparams(width = matchParent, height = matchParent)

                googleCircleHookLoadMoreFooterView = googleCircleHookLoadMoreFooterView {
                    id = R.id.swipe_load_more_footer
                    backgroundColor = Color.TRANSPARENT

                    googleCircleProgressView(R.style.GoogleCircleProgressViewStyle) {
                        id = R.id.googleProgress

                    }.lparams(width = dip(40), height = dip(40)) {
                        gravity = Gravity.CENTER
                    }

                }.lparams(width = matchParent, height = dip(72))

            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
        }

    }
}