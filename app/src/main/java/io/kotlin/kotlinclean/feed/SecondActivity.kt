package io.kotlin.kotlinclean.feed

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import io.kotlin.kotlinclean.R

class SecondActivity: Activity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("extra", "extra")
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extra = intent.getStringExtra("extra")
        Log.d("EXTRA", extra)
    }

}
