package io.kotlin.kotlinclean.feed

import io.kotlin.kotlinclean.feed.viewstate.HealthFeedErrorViewState
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedIdleViewState
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedLoadingViewState
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedViewState

class FeedDisplayer(private val feedView: FeedView): HealthFeedViewState.Visitor {

    fun show(viewState: HealthFeedViewState) {
        viewState.accept(this)
    }

    fun setListener(listener: FeedView.Listener) {
        feedView.setListener(listener)
    }

    override fun visit(idleViewState: HealthFeedIdleViewState) {
        feedView.show(idleViewState.feedViewStates())
    }

    override fun visit(errorViewState: HealthFeedErrorViewState) {
        feedView.showError()
    }

    override fun visit(loadingViewState: HealthFeedLoadingViewState) {
        feedView.showLoading()
    }

}
