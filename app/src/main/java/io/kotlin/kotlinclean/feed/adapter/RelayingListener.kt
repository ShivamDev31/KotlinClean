package io.kotlin.kotlinclean.feed.adapter

import io.kotlin.kotlinclean.feed.viewstate.AdViewState
import io.kotlin.kotlinclean.feed.viewstate.QuestionsViewState
import io.kotlin.kotlinclean.feed.viewstate.QuizViewState
import io.kotlin.kotlinclean.feed.viewstate.TipViewState

class RelayingListener: FeedAdapter.Listener {

    private var listener: FeedAdapter.Listener = object : FeedAdapter.Listener {
        override fun onAdClicked(viewState: AdViewState) {
            // no op
        }

        override fun onTipClicked(viewState: TipViewState) {
            // no op
        }

        override fun onQuestionsClicked(viewState: QuestionsViewState) {
            // no op
        }

        override fun onQuizClicked(viewState: QuizViewState) {
            // no op
        }

    }

    fun wrap(listener: FeedAdapter.Listener) {
        this.listener = listener
    }

    override fun onAdClicked(viewState: AdViewState) {
        listener.onAdClicked(viewState)
    }

    override fun onTipClicked(viewState: TipViewState) {
        listener.onTipClicked(viewState)
    }

    override fun onQuestionsClicked(viewState: QuestionsViewState) {
        listener.onQuestionsClicked(viewState)
    }

    override fun onQuizClicked(viewState: QuizViewState) {
        listener.onQuizClicked(viewState)
    }

}
