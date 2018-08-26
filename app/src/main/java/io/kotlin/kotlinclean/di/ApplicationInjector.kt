package io.kotlin.kotlinclean.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import io.kotlin.kotlinclean.app.InjectableApp
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class
])
interface ApplicationInjector {

    fun inject(injectableApp: InjectableApp)

    interface Factory {

        fun create(application: Application): ApplicationInjector
    }
}
