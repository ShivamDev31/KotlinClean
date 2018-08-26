package io.kotlin.kotlinclean.app

import android.app.Application
import io.kotlin.kotlinclean.di.ApplicationInjector
import io.kotlin.kotlinclean.di.ApplicationModule
import io.kotlin.kotlinclean.di.DaggerApplicationInjector
import io.kotlin.kotlinclean.network.NetworkModule

class CleanApp: InjectableApp(ApplicationAndroidFactory()) {

    class ApplicationAndroidFactory: ApplicationInjector.Factory {
        override fun create(application: Application): ApplicationInjector {
            return DaggerApplicationInjector.builder()
                    .applicationModule(ApplicationModule(application))
                    .networkModule(NetworkModule(application))
                    .build()
        }
    }
}
