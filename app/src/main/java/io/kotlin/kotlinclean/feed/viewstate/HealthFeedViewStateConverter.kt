package io.kotlin.kotlinclean.feed.viewstate

import android.view.View
import io.kotlin.kotlinclean.feed.*
import io.kotlin.kotlinclean.feed.api.QuizFeed
import io.kotlin.kotlinclean.rx.Converter

class HealthFeedViewStateConverter : Converter<HealthFeed, HealthFeedViewState>, Feed.Visitor {

    private val INVALID_IMAGE_URL = "http://image.url"
    private val viewStates = mutableListOf<FeedViewState>()

    override fun apply(healthFeed: HealthFeed): HealthFeedViewState {
        healthFeed.healthStories.forEach {
            it.accept(this)
        }
        return HealthFeedIdleViewState(viewStates)
    }

    override fun visit(adFeed: AdFeed) {
        val adViewState = AdViewState(
                adFeed.code,
                adFeed.title,
                adFeed.tag,
                adFeed.supportText,
                getImageVisibility(adFeed.imagePath),
                getImageUrl(adFeed.imagePath))
        viewStates.add(adViewState)
    }

    override fun visit(tipFeed: TipFeed) {
        val tipViewState = TipViewState(
                tipFeed.code,
                tipFeed.title,
                tipFeed.tag,
                tipFeed.supportText,
                getImageVisibility(tipFeed.imagePath),
                getImageUrl(tipFeed.imagePath))
        viewStates.add(tipViewState)
    }

    override fun visit(quizFeed: QuizFeed) {
        val questionsFeed = QuizViewState(
                quizFeed.code,
                quizFeed.title,
                quizFeed.tag,
                quizFeed.supportText,
                getImageVisibility(quizFeed.imagePath),
                getImageUrl(quizFeed.imagePath))
        viewStates.add(questionsFeed)
    }

    override fun visit(questionsFeed: QuestionsFeed) {
        val quizViewState = QuizViewState(
                questionsFeed.code,
                questionsFeed.title,
                questionsFeed.tag,
                questionsFeed.supportText,
                getImageVisibility(questionsFeed.imagePath),
                getImageUrl(questionsFeed.imagePath))
        viewStates.add(quizViewState)
    }

    private fun getImageVisibility(imagePath: String?): Int {
        return when (imagePath) {
            null -> View.GONE
            else -> View.VISIBLE
        }
    }

    private fun getImageUrl(imagePath: String?): String {
        return imagePath ?: INVALID_IMAGE_URL
    }

}
