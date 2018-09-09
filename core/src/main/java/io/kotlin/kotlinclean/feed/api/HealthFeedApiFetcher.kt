package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.HealthFeed
import io.reactivex.Single

class HealthFeedApiFetcher(private val feedConverter: FeedConverter, private val healthBackend: HealthBackend): HealthFetcher {


    override fun load(): Single<HealthFeed> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
