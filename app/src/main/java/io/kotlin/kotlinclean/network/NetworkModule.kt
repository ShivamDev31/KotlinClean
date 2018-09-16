package io.kotlin.kotlinclean.network

import android.app.Application
import dagger.Module
import dagger.Provides
import io.kotlin.kotlinclean.BuildConfig
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import javax.inject.Singleton

@Singleton
@Module
class NetworkModule(private val application: Application) {

    private val DEFAULT_DISK_CACHE_SIZE = 16 * 1024 * 1024 // 16MB

    private lateinit var defaultCache: Cache

    @Provides
    @Singleton
    fun baseUrl(): HttpUrl {
        return HttpUrl.parse(BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun retrofitWithDefaultCache(httpUrl: HttpUrl): Retrofit {
        return NetworkDefaults.retrofit()
                .newBuilder()
                .client(newOkHttpClientWith(defaultCache))
                .baseUrl(baseUrl())
                .build()
    }

    private fun createCache(application: Application, defaultCache: String): File {
        return File(application.cacheDir, defaultCache)
    }

    private fun newOkHttpClientWith(cache: Cache): OkHttpClient {
        val okHttpClient = NetworkDefaults.okHttpClient()
                .newBuilder()
                .cache(cache)
        if(BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(httpLoggingInterceptor())
        }
        return okHttpClient.build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val okHttpLoggingInterceptor = HttpLoggingInterceptor()
        okHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return okHttpLoggingInterceptor
    }
}
