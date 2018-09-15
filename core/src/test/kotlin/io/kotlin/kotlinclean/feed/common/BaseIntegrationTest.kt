package io.kotlin.kotlinclean.feed.common

import io.kotlin.kotlinclean.network.JsonDefaults
import io.kotlin.kotlinclean.network.NetworkDefaults

open class BaseIntegrationTest {

    companion object {
        private const val BASE_URL = "https://api.myjson.com/"
        val MOSHI = JsonDefaults.moshi()
        val RETROFIT = NetworkDefaults.retrofit()
                .newBuilder()
                .baseUrl(BASE_URL)
                .build()
        val ASSET_LOADER = TestAssetLoader()
    }

}
