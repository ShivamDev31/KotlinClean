package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.common.BaseIntegrationTest
import org.junit.Before
import org.junit.Test

class HealthFeedApiFetcherIntegrationTest : BaseIntegrationTest() {

    private lateinit var fetcher: HealthFeedApiFetcher

    @Before
    fun setUp() {
        fetcher = HealthFeedApiFetcher.from(RETROFIT, MOSHI)
    }

    @Test
    fun `should load feed data from server`() {
        val testObserver = fetcher.load().test()

        testObserver.assertComplete()
        testObserver.assertValueCount(1)
    }
}