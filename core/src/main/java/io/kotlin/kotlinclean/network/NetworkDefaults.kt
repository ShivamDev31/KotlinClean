package io.kotlin.kotlinclean.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

class NetworkDefaults {

    companion object {
        private val DEFAULT_TIMEOUT = 30

        fun okHttpClient(): OkHttpClient {
            return OkHttpClientHolder.INSTANCE.okHttpClient
        }

        fun retrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("http://invaild.value")
                    .client(okHttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }

    private enum class OkHttpClientHolder {
        INSTANCE;

        val okHttpClient: OkHttpClient

        init {
            okHttpClient = defaultOkHttpClient()
        }

        private fun defaultOkHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor())
            return builder.build()
        }

        private fun loggingInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return loggingInterceptor
        }
    }

}
