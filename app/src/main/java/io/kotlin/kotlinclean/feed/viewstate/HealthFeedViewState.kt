package io.kotlin.kotlinclean.feed.viewstate

abstract class HealthFeedViewState {

    abstract fun feedViewStates(): List<FeedViewState>

    abstract fun accept(visitor: Visitor)

    interface Visitor {

        fun visit(healthFeedIdleViewState: HealthFeedIdleViewState)
        fun visit(healthFeedErrorViewState: HealthFeedErrorViewState)
        fun visit(healthFeedLoadingViewState: HealthFeedLoadingViewState)
    }

}
