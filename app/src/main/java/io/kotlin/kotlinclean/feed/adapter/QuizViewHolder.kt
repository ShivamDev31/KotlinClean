package io.kotlin.kotlinclean.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.kotlin.kotlinclean.R
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState
import io.kotlin.kotlinclean.feed.viewstate.QuestionsViewState
import io.kotlin.kotlinclean.feed.viewstate.QuizViewState
import io.kotlin.kotlinclean.imageloader.ImageLoader

class QuizViewHolder(inflater: LayoutInflater, parent: ViewGroup, private val imageLoader: ImageLoader, private val listener: RelayingListener)
    : FeedViewHolder(inflater, parent, FeedViewState.Type.FEED_QUIZ) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvBody: TextView = itemView.findViewById(R.id.tv_body)
    private val ivBanner: ImageView = itemView.findViewById(R.id.iv_banner)

    override fun bind(viewState: FeedViewState) {
        val quizViewState = viewState as QuizViewState
        tvTitle.text = quizViewState.title
        tvBody.text = quizViewState.body
        tvTitle.text = quizViewState.title
        imageLoader.load(quizViewState.bannerImagePath)
                .into(ivBanner)
        itemView.setOnClickListener {
            listener.onQuizClicked(viewState)
        }
    }

    override fun unbind() {
        super.unbind()
        imageLoader.clear(ivBanner)
        itemView.setOnClickListener(null)
    }

    interface Listener {
        fun onQuizClicked(viewState: QuizViewState)
    }

}
