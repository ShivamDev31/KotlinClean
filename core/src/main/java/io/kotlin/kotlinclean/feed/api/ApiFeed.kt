package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.Feed


interface ApiFeed {

    companion object {
        val UNKNOWN: ApiFeed
            get() = ApiUnknownFeed()
    }

    fun accept(visitor: Visitor): Feed

    interface Visitor {

        fun visit(apiFeed: ApiAdFeed): Feed

        fun visit(apiFeed: ApiQuestionsFeed): Feed

        fun visit(apiFeed: ApiQuizFeed): Feed

        fun visit(apiFeed: ApiTipFeed): Feed
    }

}
