package com.horsege.kotlinstructure.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.horsege.kotlinstructure.ui.extensions.singleClick
import horsege.com.supportdesiginexample.ui.avtivity.ViewAnkoComponent
import kotlin.properties.Delegates

abstract class AnkoBaseAdapter<Item, Component : ViewAnkoComponent<RecyclerView>>(private val listener: (Item) -> Unit) : RecyclerView.Adapter<AnkoBaseAdapter.AnkoBaseViewHolder<Component >>() {

    var items: List<Item> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    abstract val bind: Component.(item: Item) -> Unit

    abstract fun onCreateComponent(recyclerView: RecyclerView): Component

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnkoBaseViewHolder<Component> {
        return AnkoBaseViewHolder(onCreateComponent(parent as RecyclerView))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AnkoBaseViewHolder<Component>, position: Int) {
        val item = items[position]
        holder.itemView.singleClick { listener(item) }
        holder.ui.bind(item)
    }

    class AnkoBaseViewHolder<out Component : ViewAnkoComponent<RecyclerView>>(val ui: Component)
        : RecyclerView.ViewHolder(ui.inflate())
}