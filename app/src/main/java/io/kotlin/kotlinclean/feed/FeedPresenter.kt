package io.kotlin.kotlinclean.feed

import io.kotlin.kotlinclean.navigator.Navigator

class FeedPresenter(private val navigator: Navigator) {

    companion object {
        fun create(navigator: Navigator): FeedPresenter {
            return FeedPresenter(navigator)
        }
    }

    fun goToActivitySecond() {
        navigator.toSecondActivity()
    }

}
