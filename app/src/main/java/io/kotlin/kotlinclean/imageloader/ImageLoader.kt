package io.kotlin.kotlinclean.imageloader

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.load.engine.GlideException
import okhttp3.HttpUrl

interface ImageLoader {

    fun load(uri: HttpUrl): RequestBuilder

    fun clear(imageView: ImageView)

    interface RequestBuilder {

        fun withPlaceHolder(@DrawableRes drawableResId: Int): RequestBuilder

        fun withPlaceHolder(drawable: Drawable): RequestBuilder

        fun withListener(listener: Listener): RequestBuilder

        fun centerInside(): RequestBuilder

        fun noCrossFade(): RequestBuilder

        fun into(imageView: ImageView): RequestBuilder
    }

    interface Listener {
        fun onError(exception: GlideException?)

        fun onSuccess()
    }

    interface Factory {

        fun create(context: Context): ImageLoader
    }
}
