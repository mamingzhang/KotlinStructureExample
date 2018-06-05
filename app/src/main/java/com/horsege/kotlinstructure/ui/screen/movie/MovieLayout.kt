package com.horsege.kotlinstructure.ui.screen.movie

import android.support.design.widget.AppBarLayout
import android.support.v7.widget.RecyclerView
import com.horsege.kotlinstructure.R
import horsege.com.supportdesiginexample.ui.avtivity.ActivityAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.themedToolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MovieLayout : ActivityAnkoComponent<MainActivity> {
    lateinit var recyclerView: RecyclerView

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

            recyclerView = recyclerView {

            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
        }

    }
}