package io.kotlin.kotlinclean.feed.api

import com.squareup.moshi.Moshi
import io.kotlin.kotlinclean.feed.HealthFeed
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HealthFeedApiFetcher(private val feedConverter: FeedConverter, private val healthBackend: HealthBackend) : HealthFetcher {

    companion object {
        fun from(retrofit: Retrofit, moshi: Moshi): HealthFeedApiFetcher {
            val feedConverter = FeedConverter()

            val localMoshi = moshi.newBuilder()
                    .add(ApiFeed::class.java, ApiFeedJsonAdapter.from(moshi))
                    .build()

            val healthBackend = retrofit
                    .newBuilder()
                    .addConverterFactory(MoshiConverterFactory.create(localMoshi))
                    .build()
                    .create(HealthBackend::class.java)
            return HealthFeedApiFetcher(feedConverter, healthBackend)
        }
    }

    override fun load(): Single<HealthFeed> {
        return healthBackend
                .load()
                .map(feedConverter)
    }
}
