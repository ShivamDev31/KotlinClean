package io.kotlin.kotlinclean.feed.api

data class ApiHealthFeed(val status: ApiStatus, val healthStories: List<ApiFeed>)
