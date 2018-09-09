package io.kotlin.kotlinclean.feed.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import io.kotlin.kotlinclean.common.AssetLoader
import io.kotlin.kotlinclean.feed.HealthFeed
import io.reactivex.Single
import okio.Buffer
import java.util.concurrent.Callable

class HealthFeedLocalFetcher(private val feedConverter: FeedConverter,
                             private val assetLoader: AssetLoader,
                             private val apiAdapter: JsonAdapter<ApiHealthFeed>) : HealthFetcher {

    private val HEALTH_FEED_JSON = "healthfeed.json"

    companion object {
        fun from(moshi: Moshi, assetLoader: AssetLoader): HealthFeedLocalFetcher {
            val feedConverter = FeedConverter()
            val apiAdapter = moshi
                    .newBuilder()
                    .add(ApiFeed::class.java, ApiFeedJsonAdapter.from(moshi))
                    .build()
                    .adapter<ApiHealthFeed>(ApiHealthFeed::class.java)
            return HealthFeedLocalFetcher(feedConverter, assetLoader, apiAdapter)
        }
    }

    override fun load(): Single<HealthFeed> {
        return Single.fromCallable(readHealthFeedFrom(HEALTH_FEED_JSON))
                .map(feedConverter)
    }

    private fun readHealthFeedFrom(feedJson: String): Callable<ApiHealthFeed> {
        return Callable {
            val inputStream = assetLoader.loadAsset(feedJson)
            val buffer = Buffer()
            val jsonReader = JsonReader.of(buffer.readFrom(inputStream))
            val apiHealthFeed: ApiHealthFeed = apiAdapter.fromJson(jsonReader)
            jsonReader.close()
            buffer.close()
            apiHealthFeed
        }
    }
}
