package io.kotlin.kotlinclean.feed.viewstate

import java.util.*

class HealthFeedLoadingViewState : HealthFeedViewState() {

    override fun feedViewStates(): List<FeedViewState> {
        return Collections.emptyList()
    }

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}
