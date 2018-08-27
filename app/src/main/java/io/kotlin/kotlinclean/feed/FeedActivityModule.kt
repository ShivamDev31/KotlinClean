package io.kotlin.kotlinclean.feed

import dagger.Module
import dagger.Provides
import io.kotlin.kotlinclean.navigator.AndroidNavigator
import io.kotlin.kotlinclean.navigator.Navigator

@Module
class FeedActivityModule {

    @Provides
    fun navigator(activity: FeedActivity): Navigator {
        return AndroidNavigator(activity)
    }

    @Provides
    fun feedPresenter(navigator: Navigator): FeedPresenter {
        return FeedPresenter.create(navigator)
    }

}
