package io.kotlin.kotlinclean.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AndroidSchedulingStrategyFactory(subscribingScheduler: Scheduler) :
        SchedulingStrategy.Factory(subscribingScheduler, AndroidSchedulers.mainThread()) {

    fun newThread(): AndroidSchedulingStrategyFactory {
        return AndroidSchedulingStrategyFactory(Schedulers.newThread())
    }

    fun io(): AndroidSchedulingStrategyFactory {
        return AndroidSchedulingStrategyFactory(Schedulers.io())
    }

}
