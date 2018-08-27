package io.kotlin.kotlinclean.di

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import io.kotlin.kotlinclean.feed.FeedActivity
import io.kotlin.kotlinclean.feed.FeedActivityInjector
import javax.inject.Singleton

@Singleton
@Module(subcomponents = [FeedActivityInjector::class])
interface ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(FeedActivity::class)
    fun bindFeedActivity(builder: FeedActivityInjector.Builder): AndroidInjector.Factory<out Activity>

}
