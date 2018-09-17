package io.kotlin.kotlinclean.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.kotlin.kotlinclean.R
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState
import io.kotlin.kotlinclean.feed.viewstate.QuestionsViewState
import io.kotlin.kotlinclean.imageloader.ImageLoader

class QuestionsViewHolder(inflater: LayoutInflater, parent: ViewGroup, private val imageLoader: ImageLoader, private val listener: RelayingListener)
    : FeedViewHolder(inflater, parent, FeedViewState.Type.FEED_QUESTIONS) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvBody: TextView = itemView.findViewById(R.id.tv_body)
    private val ivBanner: ImageView = itemView.findViewById(R.id.iv_banner)

    override fun bind(viewState: FeedViewState) {
        val questionsViewState = viewState as QuestionsViewState
        tvTitle.text = questionsViewState.title
        tvBody.text = questionsViewState.body
        tvTitle.text = questionsViewState.title
        imageLoader.load(questionsViewState.bannerImagePath)
                .into(ivBanner)
        itemView.setOnClickListener {
            listener.onQuestionsClicked(viewState)
        }
    }

    override fun unbind() {
        super.unbind()
        imageLoader.clear(ivBanner)
        itemView.setOnClickListener(null)
    }

    interface Listener {
        fun onQuestionsClicked(viewState: QuestionsViewState)
    }

}
