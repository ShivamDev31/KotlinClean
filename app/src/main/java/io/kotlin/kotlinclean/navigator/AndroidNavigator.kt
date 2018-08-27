package io.kotlin.kotlinclean.navigator

import android.app.Activity
import android.content.Intent
import io.kotlin.kotlinclean.feed.SecondActivity

class AndroidNavigator(private val activity: Activity): Navigator {

    override fun toSecondActivity() {
        val intent = SecondActivity.newIntent(activity)
        startActivity(intent)
    }

    private fun startActivity(intent: Intent) {
        activity.startActivity(intent)
    }
}
