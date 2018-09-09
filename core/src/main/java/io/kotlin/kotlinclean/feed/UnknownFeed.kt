package io.kotlin.kotlinclean.feed

class UnknownFeed: Feed {
    override fun accept(visitor: Feed.Visitor) {
        // no op
    }

}
