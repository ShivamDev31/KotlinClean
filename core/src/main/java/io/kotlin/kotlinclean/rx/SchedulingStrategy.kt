package io.kotlin.kotlinclean.rx

import io.reactivex.*

class SchedulingStrategy<T>(private val subscribingScheduler: Scheduler, private val observingScheduler: Scheduler) :
        ObservableTransformer<T, T>, SingleTransformer<T, T>, CompletableTransformer {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    open class Factory(private val subscribingScheduler: Scheduler, private val observingScheduler: Scheduler) {
        fun <T> create(): SchedulingStrategy<T> {
            return SchedulingStrategy(subscribingScheduler, observingScheduler)
        }

        fun getSubscribingScheduler(): Scheduler {
            return subscribingScheduler;
        }

    }

}
