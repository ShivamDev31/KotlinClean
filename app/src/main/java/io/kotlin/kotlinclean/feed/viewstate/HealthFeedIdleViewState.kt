package io.kotlin.kotlinclean.feed.viewstate

class HealthFeedIdleViewState(private val feedViewStates: List<FeedViewState>) : HealthFeedViewState() {

    override fun feedViewStates(): List<FeedViewState> {
        return feedViewStates
    }

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

}
