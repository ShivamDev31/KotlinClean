package io.kotlin.kotlinclean.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState

abstract class FeedViewHolder(inflater: LayoutInflater, parent: ViewGroup, type: FeedViewState.Type)
    : RecyclerView.ViewHolder(inflater.inflate(type.layoutId(), parent, false)) {

    abstract fun bind(viewState: FeedViewState)

    open fun unbind() {
        // no op
    }

}
