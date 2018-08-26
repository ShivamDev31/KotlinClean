package io.kotlin.kotlinclean.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class JsonModule {

    @Singleton
    @Provides
    fun moshi(): Moshi {
        return JsonDefaults.moshi()
    }
}
