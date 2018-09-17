package io.kotlin.kotlinclean.navigator

import android.app.Activity
import android.content.Intent
import android.widget.Toast

class AndroidNavigator(private val activity: Activity) : Navigator {
    override fun toAdDetail() {
        showToast("Ad clicked")
    }

    override fun toTipDetail() {
        showToast("Tip clicked")
    }

    override fun toQuestionsDetail() {
        showToast("Questions clicked")
    }

    override fun toQuizDetail() {
        showToast("Quiz clicked")
    }


    fun showToast(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    private fun startActivity(intent: Intent) {
        activity.startActivity(intent)
    }
}
