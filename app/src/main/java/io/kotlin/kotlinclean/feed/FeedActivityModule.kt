package io.kotlin.kotlinclean.feed

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.kotlin.kotlinclean.feed.api.HealthFeedApiFetcher
import io.kotlin.kotlinclean.feed.api.HealthFetcher
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedViewStateConverter
import io.kotlin.kotlinclean.imageloader.ImageLoader
import io.kotlin.kotlinclean.navigator.AndroidNavigator
import io.kotlin.kotlinclean.navigator.Navigator
import io.kotlin.kotlinclean.rx.AndroidSchedulingStrategyFactory
import retrofit2.Retrofit

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

    @Provides
    fun feedFetcher(retrofit: Retrofit, moshi: Moshi): HealthFetcher {
        return HealthFeedApiFetcher.from(retrofit, moshi)
    }

    @Provides
    fun feedUseCase(fetcher: HealthFetcher): FeedUseCase {
        val viewStateConverter = HealthFeedViewStateConverter()
        return FeedUseCase(fetcher, viewStateConverter, AndroidSchedulingStrategyFactory.io())
    }

}
