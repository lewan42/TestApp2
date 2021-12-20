package dev.fabula.android.app.di

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dev.fabula.android.R

interface GlideProvider {
    fun provideRequestManager() : RequestManager
    fun provideRequestBuilder() : RequestBuilder<Drawable>
}

@Module
class GlideModule {

    @Provides
    fun provideRequestManager(context: Context) : RequestManager =
        Glide.with(context)
            .setDefaultRequestOptions(RequestOptions().timeout(3000))

    @Provides
    fun provideRequestBuilder(imageLoader: RequestManager) : RequestBuilder<Drawable> =
        imageLoader
            .asDrawable()
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.ic_image_placeholder_24dp)
            .error(R.drawable.ic_image_broken_24dp)
            .fallback(R.drawable.ic_image_fallback_24dp)
            .transition(DrawableTransitionOptions.withCrossFade())
}