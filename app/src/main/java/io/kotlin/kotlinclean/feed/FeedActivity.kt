package io.kotlin.kotlinclean.feed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.kotlin.kotlinclean.R
import kotlinx.android.synthetic.main.activity_feed.*
import javax.inject.Inject

class FeedActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: FeedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_feed)
        text.setOnClickListener {
            presenter.goToActivitySecond()
        }
    }
}
