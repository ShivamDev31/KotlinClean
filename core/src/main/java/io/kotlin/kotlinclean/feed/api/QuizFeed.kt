package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.Feed

data class QuizFeed(val code: Int,
                    val title: String,
                    val body: String,
                    val tag: String,
                    val supportText: String,
                    val imagePath: String?) : Feed {
    override fun accept(visitor: Feed.Visitor) {
        visitor.visit(this)
    }
}
