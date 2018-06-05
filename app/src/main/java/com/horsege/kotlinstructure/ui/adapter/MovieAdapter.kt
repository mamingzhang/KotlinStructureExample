package com.horsege.kotlinstructure.ui.adapter

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.horsege.kotlinstructure.domain.entity.MovieDomain
import horsege.com.supportdesiginexample.ui.avtivity.ViewAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class MovieAdapter(listener: (MovieDomain) -> Unit) : AnkoBaseAdapter<MovieDomain, MovieAdapter.Component>(listener) {
    override val bind: Component.(item: MovieDomain) -> Unit = {
        Glide.with(imageView.context).load(it.avatar).into(imageView)
        titleTxt.text = it.title
        yearTxt.text = it.year
    }

    override fun onCreateComponent(recyclerView: RecyclerView) = Component(recyclerView)

    class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var imageView: ImageView
        lateinit var titleTxt: TextView
        lateinit var yearTxt: TextView

        override fun createView(ui: AnkoContext<RecyclerView>) = with(ui) {
            constraintLayout {
                imageView = imageView {
                    id = View.generateViewId()
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = dip(100), height = dip(100)) {
                    leftToLeft = PARENT_ID
                    leftMargin = dip(10)
                }

                titleTxt = textView {
                    textSize = sp(12).toFloat()
                }.lparams(width = wrapContent) {
                    leftToRight = imageView.id
                    topToTop = imageView.id

                    leftMargin = dip(10)
                    rightMargin = dip(10)
                    topMargin = dip(2)
                }

                yearTxt = textView {
                    textSize = sp(12).toFloat()
                }.lparams(width = wrapContent) {
                    leftToRight = imageView.id
                    bottomToBottom = imageView.id

                    leftMargin = dip(10)
                    rightMargin = dip(10)
                    bottomMargin = dip(2)
                }
            }
        }

    }
}