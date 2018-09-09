package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.Feed

class ApiUnknownFeed: ApiFeed {
    override fun accept(visitor: ApiFeed.Visitor): Feed {
        return Feed.EMPTY
    }

}
