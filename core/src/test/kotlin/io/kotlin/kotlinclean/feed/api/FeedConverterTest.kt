package io.kotlin.kotlinclean.feed.api

import com.google.common.truth.Truth.assertThat
import io.kotlin.kotlinclean.feed.AdFeed
import io.kotlin.kotlinclean.feed.Feed
import io.kotlin.kotlinclean.feed.QuestionsFeed
import io.kotlin.kotlinclean.feed.TipFeed
import org.junit.Before
import org.junit.Test
import java.util.*

class FeedConverterTest {

    private val API_STATUS = ApiStatus(300, "failed")
    private val API_MEDIA = ApiMedia("image path", "type")
    private val AD_FEED = ApiAdFeed(200, "Ad", "Ad Body", "Ad Tag", " AdText", Arrays.asList(API_MEDIA))
    private val TIP_FEED = ApiTipFeed(200, "Tip", "Tip Body", "Tip Tag", "Tip Text", Arrays.asList(API_MEDIA))
    private val QUESTIONS_FEED = ApiQuestionsFeed(200, "Questions", "Questions Body", "QuestionsTag", "Questions Text", Arrays.asList(API_MEDIA))
    private val QUIZ_FEED = ApiQuizFeed(200, "Quiz", "Quiz Body", "Quiz Tag", "Quiz Text", Arrays.asList(API_MEDIA))

    private lateinit var converter: FeedConverter

    @Before
    fun setUp() {
        converter = FeedConverter()
    }

    @Test
    fun `should return empty if status code is not 200`() {
        val apiHealthFeed = ApiHealthFeedBuilder()
                .withStatus(API_STATUS)
                .withFeeds(AD_FEED, TIP_FEED)
                .build()
        val healthFeed = converter.apply(apiHealthFeed)

        assertThat(healthFeed.healthStories).isEqualTo(emptyList<Feed>())
    }

    @Test
    fun `should convert apiadfeed to adfeed`() {
        val apiAdFeed = ApiHealthFeedBuilder()
                .withFeeds(AD_FEED)
                .build()

        val healthFeed = converter.apply(apiAdFeed)

        val expectedAdFeed = AdFeed(200, "Ad", "Ad Body", "Ad Tag", " AdText", "image path")
        assertThat(healthFeed.healthStories[0]).isEqualTo(expectedAdFeed)
    }

    @Test
    fun `should convert apitipfeed to tipfeed`() {
        val apiTipFeed = ApiHealthFeedBuilder()
                .withFeeds(TIP_FEED)
                .build()

        val healthFeed = converter.apply(apiTipFeed)

        val expectedTipFeed = TipFeed(200, "Tip", "Tip Body", "Tip Tag", "Tip Text", "image path")
        assertThat(healthFeed.healthStories[0]).isEqualTo(expectedTipFeed)
    }

    @Test
    fun `should convert apiquestionsfeed to tipfeed`() {
        val apiTipFeed = ApiHealthFeedBuilder()
                .withFeeds(QUESTIONS_FEED)
                .build()

        val healthFeed = converter.apply(apiTipFeed)

        val expectedQuestionsFeed = QuestionsFeed(200, "Questions", "Questions Body", "QuestionsTag", "Questions Text", "image path")
        assertThat(healthFeed.healthStories[0]).isEqualTo(expectedQuestionsFeed)
    }

    @Test
    fun `should convert apiquizfeed to tipfeed`() {
        val apiTipFeed = ApiHealthFeedBuilder()
                .withFeeds(QUIZ_FEED)
                .build()

        val healthFeed = converter.apply(apiTipFeed)

        val expectedQuizFeed = QuizFeed(200, "Quiz", "Quiz Body", "Quiz Tag", "Quiz Text", "image path")
        assertThat(healthFeed.healthStories[0]).isEqualTo(expectedQuizFeed)
    }
}