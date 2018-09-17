package io.kotlin.kotlinclean.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.kotlin.kotlinclean.R
import io.kotlin.kotlinclean.feed.viewstate.AdViewState
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState
import io.kotlin.kotlinclean.imageloader.ImageLoader

class AdViewHolder(inflater: LayoutInflater, parent: ViewGroup, private val imageLoader: ImageLoader, private val listener: RelayingListener)
    : FeedViewHolder(inflater, parent, FeedViewState.Type.FEED_AD) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvBody: TextView = itemView.findViewById(R.id.tv_body)
    private val ivBanner: ImageView = itemView.findViewById(R.id.iv_banner)

    override fun bind(viewState: FeedViewState) {
        val adViewState = viewState as AdViewState
        tvTitle.text = adViewState.title
        tvBody.text = adViewState.body
        tvTitle.text = adViewState.title
        imageLoader.load(adViewState.bannerImagePath)
                .into(ivBanner)
        itemView.setOnClickListener {
            listener.onAdClicked(viewState)
        }
    }

    override fun unbind() {
        super.unbind()
        imageLoader.clear(ivBanner)
        itemView.setOnClickListener(null)
    }

    interface Listener {
        fun onAdClicked(viewState: AdViewState)
    }

}
