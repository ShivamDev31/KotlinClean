package io.kotlin.kotlinclean.feed.api

import java.util.*

class ApiHealthFeedBuilder {

    private var apiStatus = ApiStatus(200, "Success")
    private var feeds = mutableListOf<ApiFeed>()

    fun withStatus(apiStatus: ApiStatus): ApiHealthFeedBuilder {
        this.apiStatus = apiStatus
        return this
    }


    fun withFeeds(vararg feeds: ApiFeed): ApiHealthFeedBuilder {
        this.feeds = Arrays.asList(*feeds)
        return this
    }

    fun build(): ApiHealthFeed {
        return ApiHealthFeed(apiStatus, feeds)
    }
}
