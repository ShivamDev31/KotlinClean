package io.kotlin.kotlinclean.feed.viewstate

class TipViewStateval(code: Int,
                      val title: String,
                      val tag: String,
                      val supportText: String,
                      val bannerImageVisibility: Int,
                      val bannerImagePath: String) : FeedViewState {

    override fun type(): FeedViewState.Type = FeedViewState.Type.FEED_TIP
}
