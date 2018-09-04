package io.kotlin.kotlinclean.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulingStrategyFactory(subscribingScheduler: Scheduler, observingScheduler: Scheduler) :
        SchedulingStrategy.Factory(subscribingScheduler, observingScheduler) {

    fun immediate(): TestSchedulingStrategyFactory {
        return TestSchedulingStrategyFactory(Schedulers.trampoline(), Schedulers.trampoline())
    }

    fun subscribing(scheduler: Scheduler): TestSchedulingStrategyFactory {
        return TestSchedulingStrategyFactory(scheduler, Schedulers.trampoline())
    }

}
