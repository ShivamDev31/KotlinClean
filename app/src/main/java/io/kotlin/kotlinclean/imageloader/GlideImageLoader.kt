package io.kotlin.kotlinclean.imageloader

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import okhttp3.HttpUrl

class GlideImageLoader(private val diskCachingStrategy: DiskCacheStrategy, private val requestManager: RequestManager) : ImageLoader {

    override fun load(uri: HttpUrl): ImageLoader.RequestBuilder {
        val requestBuilder: RequestBuilder<Drawable> = requestManager.load(uri)
        return GlideRequestBuilder(diskCachingStrategy, requestBuilder)
    }

    override fun load(url: String): ImageLoader.RequestBuilder {
        val requestBuilder: RequestBuilder<Drawable> = requestManager.load(url)
        return GlideRequestBuilder(diskCachingStrategy, requestBuilder)
    }

    override fun clear(imageView: ImageView) {
        requestManager.clear(imageView)
    }

    class GlideRequestBuilder(private val diskCachingStrategy: DiskCacheStrategy, private val requestBuilder: RequestBuilder<Drawable>) :
            ImageLoader.RequestBuilder {

        private val requestOptions: RequestOptions = RequestOptions().diskCacheStrategy(diskCachingStrategy)
        var useCrossFade = true

        override fun withPlaceHolder(drawableResId: Int): ImageLoader.RequestBuilder {
            requestOptions.placeholder(drawableResId)
            return this
        }

        override fun withPlaceHolder(drawable: Drawable): ImageLoader.RequestBuilder {
            requestOptions.placeholder(drawable)
            return this
        }

        override fun withListener(listener: ImageLoader.Listener): ImageLoader.RequestBuilder {
            requestBuilder.listener(GlideImageLoader.RelayingRequestListener(listener))
            return this
        }

        override fun centerInside(): ImageLoader.RequestBuilder {
            requestOptions.centerInside()
            return this
        }

        override fun noCrossFade(): ImageLoader.RequestBuilder {
            useCrossFade = false
            return this
        }

        override fun into(imageView: ImageView): ImageLoader.RequestBuilder {
            if (useCrossFade) {
                requestBuilder.transition(DrawableTransitionOptions.withCrossFade())
            }
            requestBuilder.apply(requestOptions)
                    .into(imageView)
            return this
        }
    }

    class RelayingRequestListener(private val listener: ImageLoader.Listener) : RequestListener<Drawable> {

        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
            listener.onError(e)
            return false
        }

        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
            listener.onSuccess()
            return false
        }

    }

    class Factory(private val diskCachingStrategy: DiskCacheStrategy) : ImageLoader.Factory {
        override fun create(context: Context): ImageLoader {
            return GlideImageLoader(diskCachingStrategy, Glide.with(context))
        }
    }

}
