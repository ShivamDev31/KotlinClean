package io.kotlin.kotlinclean.feed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.kotlin.kotlinclean.R
import javax.inject.Inject

class FeedActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: FeedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        AndroidInjection.inject(this)
        presenter.startPresenting()
    }

    override fun onDestroy() {
        presenter.stopPresenting()
        super.onDestroy()
    }
}
