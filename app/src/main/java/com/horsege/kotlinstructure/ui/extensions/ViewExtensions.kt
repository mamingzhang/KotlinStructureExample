package com.horsege.kotlinstructure.ui.extensions

import android.view.View
import com.horsege.kotlinstructure.ui.adapter.SingleClickListener

fun View.singleClick(click: (View?) -> Unit) {
    setOnClickListener(SingleClickListener(click))
}