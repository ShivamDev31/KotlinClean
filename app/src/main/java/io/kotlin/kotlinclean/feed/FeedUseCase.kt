package io.kotlin.kotlinclean.feed

import io.kotlin.kotlinclean.feed.api.HealthFetcher
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedLoadingViewState
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedViewState
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedViewStateConverter
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedViewStateErrorConverter
import io.kotlin.kotlinclean.rx.SchedulingStrategy
import io.reactivex.Observable

class FeedUseCase(private val fetcher: HealthFetcher,
                  private val converter: HealthFeedViewStateConverter,
                  private val schedulingStrategyFactory: SchedulingStrategy.Factory) {

    fun healthFeed(): Observable<HealthFeedViewState> {
        val loading = HealthFeedLoadingViewState()
        return fetcher
                .load()
                .toObservable()
                .map(converter)
                .startWith(loading)
                .compose(HealthFeedViewStateErrorConverter())
                .compose(schedulingStrategyFactory.create())
    }

}
