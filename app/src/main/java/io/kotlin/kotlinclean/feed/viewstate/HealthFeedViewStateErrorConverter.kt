package io.kotlin.kotlinclean.feed.viewstate

import com.squareup.moshi.JsonEncodingException
import io.kotlin.kotlinclean.feed.viewstate.HealthFeedErrorViewState.Type.*
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function
import retrofit2.HttpException
import java.io.IOException

class HealthFeedViewStateErrorConverter : ObservableTransformer<HealthFeedViewState, HealthFeedViewState> {

    private val HTTP_SERVER_ERROR_CODE = 500

    override fun apply(upstream: Observable<HealthFeedViewState>): ObservableSource<HealthFeedViewState> {
        return upstream
                .onErrorResumeNext(Function {
                    Observable.just(convertToCause(it))
                })
    }

    private fun convertToCause(cause: Throwable): HealthFeedViewState? {
        return when (cause) {
            is HttpException -> {
                when (HTTP_SERVER_ERROR_CODE) {
                    cause.code() -> HealthFeedErrorViewState(cause, SERVER)
                    else -> HealthFeedErrorViewState(cause, NOT_FOUND)
                }
            }
            is JsonEncodingException -> return HealthFeedErrorViewState(cause, UNKNOWN)
            is IOException -> HealthFeedErrorViewState(cause, CONNECTION)
            else -> HealthFeedErrorViewState(cause, NOT_FOUND)
        }
    }

}
