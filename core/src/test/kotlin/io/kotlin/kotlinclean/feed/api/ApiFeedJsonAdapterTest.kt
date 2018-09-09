package io.kotlin.kotlinclean.feed.api

import com.google.common.truth.Truth.assertThat
import io.kotlin.kotlinclean.feed.test.TestResources
import io.kotlin.kotlinclean.network.JsonDefaults
import org.junit.Before
import org.junit.Test

class ApiFeedJsonAdapterTest {

    private lateinit var apiFeedJsonAdapter: ApiFeedJsonAdapter

    @Before
    fun setUp() {
        apiFeedJsonAdapter = ApiFeedJsonAdapter.from(JsonDefaults.moshi())
    }

    @Test
    internal fun `should parse ad data correctly`() {
        val adFeed: ApiAdFeed = apiFeedJsonAdapter.fromJson(TestResources.jsonReaderFrom("ad_feed.json")) as ApiAdFeed

        assertThat(adFeed.code).isEqualTo(15)
        assertThat(adFeed.title).isEqualTo("Get Health Tests Done from Comfort of your Home")
        assertThat(adFeed.body).isEqualTo("It is well known that ‘prevention is better than cure.")
        assertThat(adFeed.supportText).isEqualTo("Limited time offer. Avail Now!")
        assertThat(adFeed.tag).isEqualTo("Full Body")
        assertThat(adFeed.mediaList?.get(0)?.path).isEqualTo("http://www.ancestryimages.com/stockimages/sm0112-Essex-Moule-l.jpg")
        assertThat(adFeed.mediaList?.get(0)?.type).isEqualTo("image")
    }

    @Test
    internal fun `should parse tip data correctly`() {
        val tipFeed: ApiTipFeed = apiFeedJsonAdapter.fromJson(TestResources.jsonReaderFrom("tip_feed.json")) as ApiTipFeed

        assertThat(tipFeed.code).isEqualTo(16)
        assertThat(tipFeed.title).isEqualTo("Neurobics for your mind.")
        assertThat(tipFeed.body).isEqualTo("Get your brain fizzing with energy. American researchers coined the term ‘neurobics’ for tasks which activate the brain's own biochemical pathways and to bring new pathways online that can help to strengthen or preserve brain circuits.")
        assertThat(tipFeed.supportText).isEqualTo("stretching exercises")
        assertThat(tipFeed.tag).isEqualTo("Stretching")
        assertThat(tipFeed.mediaList?.get(0)?.path).isEqualTo("http://www.antiqueprints.com/images/ai0/i0772.jpg")
        assertThat(tipFeed.mediaList?.get(0)?.type).isEqualTo("image")
    }

    @Test
    internal fun `should parse question data correctly`() {
        val questionFeed = apiFeedJsonAdapter.fromJson(TestResources.jsonReaderFrom("tip_feed.json")) as ApiQuestionsFeed

        assertThat(questionFeed.code).isEqualTo(14)
        assertThat(questionFeed.title).isEqualTo("Will a person with Type 2 diabetes under control end up with the need for insulin?")
        assertThat(questionFeed.body).isEqualTo("As you may have read, Type 2 diabetes is a progressive disease.")
        assertThat(questionFeed.mediaList?.get(0)?.path).isEqualTo("http://www.ancestryimages.com/stockimages/sm0118-York-plan(g387)-l.jpg")
        assertThat(questionFeed.mediaList?.get(0)?.type).isEqualTo("image")
    }

    @Test
    internal fun `should parse quiz data correctly`() {
        val quizFeed = apiFeedJsonAdapter.fromJson(TestResources.jsonReaderFrom("tip_feed.json")) as ApiQuizFeed

        assertThat(quizFeed.code).isEqualTo(14)
        assertThat(quizFeed.title).isEqualTo("Will a person with Type 2 diabetes under control end up with the need for insulin?")
        assertThat(quizFeed.body).isEqualTo("As you may have read, Type 2 diabetes is a progressive disease.")
        assertThat(quizFeed.mediaList?.get(0)?.path).isEqualTo("http://www.ancestryimages.com/stockimages/sm0118-York-plan(g387)-l.jpg")
        assertThat(quizFeed.mediaList?.get(0)?.type).isEqualTo("image")
    }
}
