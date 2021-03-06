package io.kotlin.kotlinclean.feed.viewstate

class QuestionsViewState (
        val code: Int,
        val title: String,
        val body: String,
        val tag: String,
        val supportText: String,
        val bannerImageVisibility: Int,
        val bannerImagePath: String) : FeedViewState {

    override fun type(): FeedViewState.Type = FeedViewState.Type.FEED_QUESTIONS
}
