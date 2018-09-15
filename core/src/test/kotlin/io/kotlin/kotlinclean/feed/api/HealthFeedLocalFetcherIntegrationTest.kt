package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.common.BaseIntegrationTest
import org.junit.Before
import org.junit.Test

class HealthFeedLocalFetcherIntegrationTest: BaseIntegrationTest() {

    private lateinit var fetcher: HealthFeedLocalFetcher

    @Before
    fun setUp() {
        fetcher = HealthFeedLocalFetcher.from(MOSHI, ASSET_LOADER)
    }

    @Test
    fun `should load feed data from local`() {
        val testObserver = fetcher.load().test()

        testObserver.assertComplete()
        testObserver.assertValueCount(1)
    }
}