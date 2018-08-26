package io.kotlin.kotlinclean.app

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasDispatchingActivityInjector
import io.kotlin.kotlinclean.di.ApplicationInjector
import javax.inject.Inject

abstract class InjectableApp(private val applicationInjectorFactory: ApplicationInjector.Factory): Application(), HasDispatchingActivityInjector {

    @Inject
    internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        val applicationInjector = applicationInjectorFactory.create(this)
        applicationInjector.inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }

}
