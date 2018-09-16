package io.kotlin.kotlinclean.feed.viewstate

import java.util.*

class HealthFeedErrorViewState(errorCause: Throwable, errorType: Type) : HealthFeedViewState() {

    override fun feedViewStates(): List<FeedViewState> {
        return Collections.emptyList()
    }

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    enum class Type {
        SERVER,
        NOT_FOUND,
        CONNECTION,
        UNKNOWN;
    }

}
