package io.kotlin.kotlinclean.feed

import io.kotlin.kotlinclean.feed.api.QuizFeed

interface Feed {

    companion object {
        val EMPTY: Feed
            get() = UnknownFeed()
    }

    fun accept(visitor: Visitor)

    interface Visitor {
        fun visit(adFeed: AdFeed)
        fun visit(tipFeed: TipFeed)
        fun visit(quizFeed: QuizFeed)
        fun visit(questionsFeed: QuestionsFeed)
    }

}
