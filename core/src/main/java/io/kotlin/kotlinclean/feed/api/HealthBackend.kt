package io.kotlin.kotlinclean.feed.api

import io.reactivex.Single
import retrofit2.http.GET

interface HealthBackend {

    @GET("bins/fseak")
    fun load(): Single<ApiHealthFeed>

}
