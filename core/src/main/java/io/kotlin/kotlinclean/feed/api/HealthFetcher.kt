package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.HealthFeed
import io.reactivex.Single

interface HealthFetcher {

    fun load(): Single<HealthFeed>
}
