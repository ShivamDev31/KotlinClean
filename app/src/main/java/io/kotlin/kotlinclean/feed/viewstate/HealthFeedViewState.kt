package io.kotlin.kotlinclean.feed.viewstate

abstract class HealthFeedViewState {

    abstract fun feedViewStates(): List<FeedViewState>

    abstract fun accept(visitor: Visitor)

    interface Visitor {

        fun visit(idleViewState: HealthFeedIdleViewState)
        fun visit(errorViewState: HealthFeedErrorViewState)
        fun visit(loadingViewState: HealthFeedLoadingViewState)
    }

}
