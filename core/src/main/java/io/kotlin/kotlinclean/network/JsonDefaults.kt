package io.kotlin.kotlinclean.network

import com.squareup.moshi.Moshi

class JsonDefaults {

    private fun JsonDefaults() {
        throw UnsupportedOperationException("No instance allowed!")
    }

    companion object {
        private val MOSHI = Moshi.Builder().build()

        fun moshi(): Moshi {
            return MOSHI
        }
    }
}
