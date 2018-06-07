package com.horsege.kotlinstructure.ui.extensions

import android.view.ViewManager
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout
import com.horsege.kotlinstructure.ui.views.GoogleCircleProgressView
import com.horsege.kotlinstructure.ui.views._GoogleCircleHookLoadMoreFooterView
import com.horsege.kotlinstructure.ui.views._GoogleCircleHookRefreshHeaderView
import com.horsege.kotlinstructure.ui.views._SwipeToLoadLayout
import com.horsege.kotlinstructure.ui.views.footer.GoogleCircleHookLoadMoreFooterView
import com.horsege.kotlinstructure.ui.views.header.GoogleCircleHookRefreshHeaderView
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.swipeToLoadLayout(theme: Int = 0): SwipeToLoadLayout = swipeToLoadLayout(theme) {}
inline fun ViewManager.swipeToLoadLayout(theme: Int = 0, init: _SwipeToLoadLayout.() -> Unit): SwipeToLoadLayout = ankoView(::_SwipeToLoadLayout, theme, init)

inline fun ViewManager.googleCircleHookRefreshHeaderView(theme: Int = 0): GoogleCircleHookRefreshHeaderView = googleCircleHookRefreshHeaderView(theme) {}
inline fun ViewManager.googleCircleHookRefreshHeaderView(theme: Int = 0, init: _GoogleCircleHookRefreshHeaderView.() -> Unit): GoogleCircleHookRefreshHeaderView = ankoView(::_GoogleCircleHookRefreshHeaderView, theme, init)

inline fun ViewManager.googleCircleHookLoadMoreFooterView(theme: Int = 0): GoogleCircleHookLoadMoreFooterView = googleCircleHookLoadMoreFooterView(theme) {}
inline fun ViewManager.googleCircleHookLoadMoreFooterView(theme: Int = 0, init: _GoogleCircleHookLoadMoreFooterView.() -> Unit): GoogleCircleHookLoadMoreFooterView = ankoView(::_GoogleCircleHookLoadMoreFooterView, theme, init)

inline fun ViewManager.googleCircleProgressView(theme: Int = 0): GoogleCircleProgressView = googleCircleProgressView(theme) {}
inline fun ViewManager.googleCircleProgressView(theme: Int = 0, init: GoogleCircleProgressView.() -> Unit): GoogleCircleProgressView = ankoView(::GoogleCircleProgressView, theme, init)
