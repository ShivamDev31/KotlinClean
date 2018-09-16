package io.kotlin.kotlinclean.navigator

import android.app.Activity
import android.content.Intent

class AndroidNavigator(private val activity: Activity): Navigator {

    private fun startActivity(intent: Intent) {
        activity.startActivity(intent)
    }
}
