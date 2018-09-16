package io.kotlin.kotlinclean.feed.viewstate

import android.support.annotation.LayoutRes
import io.kotlin.kotlinclean.R

interface FeedViewState {

    enum class Type constructor(@LayoutRes val layoutId: Int) {
        FEED_AD(R.layout.ad_feed_item),
        FEED_TIP(R.layout.tip_feed_item),
        FEED_QUIZ(R.layout.quiz_feed_item),
        FEED_QUESTIONS(R.layout.qna_feed_item);

        companion object {
            fun from(value: Int): Type = Type.values()[value]
        }

        fun layoutId(): Int {
            return layoutId
        }

        fun value(): Int = ordinal
    }


    fun type(): Type
}
