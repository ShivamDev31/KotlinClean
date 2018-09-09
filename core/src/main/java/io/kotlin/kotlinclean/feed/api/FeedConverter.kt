package io.kotlin.kotlinclean.feed.api

import io.kotlin.kotlinclean.feed.*
import io.kotlin.kotlinclean.rx.Converter

class FeedConverter : Converter<ApiHealthFeed, HealthFeed>, ApiFeed.Visitor {

    override fun apply(apiHealthFeed: ApiHealthFeed): HealthFeed {
        val feeds = mutableListOf<Feed>()
        if (apiHealthFeed.status.code == 200) {
            val apiFeeds = apiHealthFeed.healthStories
            apiFeeds.forEach {
                val feed = it.accept(this)
                feeds.add(feed)
            }
        }
        return HealthFeed(feeds)
    }

    override fun visit(apiFeed: ApiAdFeed): Feed {
        val mediaList = mutableListOf<Media>()
        apiFeed.mediaList?.forEach {
            mediaList.add(Media(it.path, it.type))
        }
        return AdFeed(apiFeed.code, apiFeed.title, apiFeed.body, apiFeed.tag, apiFeed.supportText, imagePathFromMedia(mediaList))
    }

    override fun visit(apiFeed: ApiQuestionsFeed): Feed {
        val mediaList = mutableListOf<Media>()
        apiFeed.mediaList?.forEach {
            mediaList.add(Media(it.path, it.type))
        }
        return QuestionsFeed(apiFeed.code, apiFeed.title, apiFeed.body, apiFeed.tag, apiFeed.supportText, imagePathFromMedia(mediaList))
    }

    override fun visit(apiFeed: ApiQuizFeed): Feed {
        val mediaList = mutableListOf<Media>()
        apiFeed.mediaList?.forEach {
            mediaList.add(Media(it.path, it.type))
        }
        return QuizFeed(apiFeed.code, apiFeed.title, apiFeed.body, apiFeed.tag, apiFeed.supportText, imagePathFromMedia(mediaList))
    }

    override fun visit(apiFeed: ApiTipFeed): Feed {
        val mediaList = mutableListOf<Media>()
        apiFeed.mediaList?.forEach {
            mediaList.add(Media(it.path, it.type))
        }
        return TipFeed(apiFeed.code, apiFeed.title, apiFeed.body, apiFeed.tag, apiFeed.supportText, imagePathFromMedia(mediaList))
    }

    private fun imagePathFromMedia(mediaList: List<Media>?): String? {
        return mediaList?.get(0)?.path
    }
}
