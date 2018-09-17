package io.kotlin.kotlinclean.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.kotlin.kotlinclean.R
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState
import io.kotlin.kotlinclean.feed.viewstate.QuizViewState
import io.kotlin.kotlinclean.feed.viewstate.TipViewState
import io.kotlin.kotlinclean.imageloader.ImageLoader

class TipViewHolder(inflater: LayoutInflater, parent: ViewGroup, private val imageLoader: ImageLoader, private val listener: RelayingListener)
: FeedViewHolder(inflater, parent, FeedViewState.Type.FEED_TIP) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvBody: TextView = itemView.findViewById(R.id.tv_body)
    private val ivBanner: ImageView = itemView.findViewById(R.id.iv_banner)

    override fun bind(viewState: FeedViewState) {
        val tipViewState = viewState as TipViewState
        tvTitle.text = tipViewState.title
        tvBody.text = tipViewState.body
        tvTitle.text = tipViewState.title
        imageLoader.load(tipViewState.bannerImagePath)
                .into(ivBanner)
        itemView.setOnClickListener {
            listener.onTipClicked(viewState)
        }
    }

    override fun unbind() {
        super.unbind()
        imageLoader.clear(ivBanner)
        itemView.setOnClickListener(null)
    }

    interface Listener {
        fun onTipClicked(viewState: TipViewState)
    }

}
