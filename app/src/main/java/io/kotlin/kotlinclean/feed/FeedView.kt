package io.kotlin.kotlinclean.feed

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import io.kotlin.kotlinclean.R
import io.kotlin.kotlinclean.feed.adapter.FeedAdapter
import io.kotlin.kotlinclean.feed.viewstate.*
import io.kotlin.kotlinclean.imageloader.ImageLoader

class FeedView(private val rvFeed: RecyclerView, private val pbLoader: ProgressBar, private val tvError: TextView, private val adapter: FeedAdapter) {

    companion object {
        fun from(activity: FeedActivity, imageLoader: ImageLoader): FeedView {
            val rvFeed = activity.findViewById<RecyclerView>(R.id.rv_feed)
            val pbLoader = activity.findViewById<ProgressBar>(R.id.pb_loading)
            val tvError = activity.findViewById<TextView>(R.id.tv_error)
            val adapter = FeedAdapter(LayoutInflater.from(activity), imageLoader)
            rvFeed.layoutManager = LinearLayoutManager(activity)
            rvFeed.adapter = adapter
            return FeedView(rvFeed, pbLoader, tvError, adapter)
        }
    }

    fun setListener(listener: Listener) {
        adapter.setListener(object : FeedAdapter.Listener {
            override fun onAdClicked(viewState: AdViewState) {
                listener.onAdClicked(viewState)
            }

            override fun onTipClicked(viewState: TipViewState) {
                listener.onTipClicked(viewState)
            }

            override fun onQuestionsClicked(viewState: QuestionsViewState) {
                listener.onQuestionsClicked(viewState)
            }

            override fun onQuizClicked(viewState: QuizViewState) {
                listener.onQuizClicked(viewState)
            }
        })
    }

    fun show(viewStates: List<FeedViewState>) {
        rvFeed.visibility = VISIBLE
        pbLoader.visibility = GONE
        tvError.visibility = GONE
        adapter.setViewStates(viewStates)
    }

    fun showLoading() {
        rvFeed.visibility = GONE
        pbLoader.visibility = VISIBLE
        tvError.visibility = GONE
    }

    fun showError() {
        rvFeed.visibility = GONE
        pbLoader.visibility = GONE
        tvError.visibility = VISIBLE
    }

    interface Listener {

//        val NO_OP = object : Listener {
//            override fun onAdClicked(viewState: AdViewState) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onTipClicked(viewState: TipViewState) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onQuestionsClicked(viewState: QuestionsViewState) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onQuizClicked(viewState: QuizViewState) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }

        fun onAdClicked(viewState: AdViewState)

        fun onTipClicked(viewState: TipViewState)

        fun onQuestionsClicked(viewState: QuestionsViewState)

        fun onQuizClicked(viewState: QuizViewState)
    }

}
