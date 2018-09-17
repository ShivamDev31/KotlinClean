package io.kotlin.kotlinclean.di

import android.app.Application
import dagger.Module
import dagger.Provides
import io.kotlin.kotlinclean.common.AndroidAssetLoader
import io.kotlin.kotlinclean.imageloader.ImageLoaderModule
import io.kotlin.kotlinclean.network.JsonModule
import io.kotlin.kotlinclean.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Module(includes = [NetworkModule::class, JsonModule::class, ImageLoaderModule::class])
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun application(): Application {
        return application
    }

    @Provides
    fun assetLoader(): AndroidAssetLoader {
        return AndroidAssetLoader(application)
    }

}
