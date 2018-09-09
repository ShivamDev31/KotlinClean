package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.Feed

data class ApiQuizFeed(val code: Int,
                       val title: String,
                       val body: String,
                       val tag: String,
                       val supportText: String,
                       val mediaList: List<ApiMedia>?) : ApiFeed {

    override fun accept(visitor: ApiFeed.Visitor): Feed {
        return visitor.visit(this)
    }
}
