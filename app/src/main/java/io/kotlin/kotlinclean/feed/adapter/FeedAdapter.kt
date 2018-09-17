package io.kotlin.kotlinclean.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState
import io.kotlin.kotlinclean.feed.viewstate.FeedViewState.Type.*
import io.kotlin.kotlinclean.imageloader.ImageLoader

class FeedAdapter(private val inflater: LayoutInflater, private val imageLoader: ImageLoader) : RecyclerView.Adapter<FeedViewHolder>() {

    private val listener = RelayingListener()

    private val viewStates = mutableListOf<FeedViewState>()

    fun setListener(listener: Listener) {
        this.listener.wrap(listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val type = FeedViewState.Type.from(viewType)
        return when (type) {
            FEED_AD -> AdViewHolder(inflater, parent, imageLoader, listener)
            FEED_TIP -> TipViewHolder(inflater, parent, imageLoader, listener)
            FEED_QUIZ -> QuizViewHolder(inflater, parent, imageLoader, listener)
            FEED_QUESTIONS -> QuestionsViewHolder(inflater, parent, imageLoader, listener)
        }
    }

    override fun getItemCount() = viewStates.size

    override fun onBindViewHolder(viewHolder: FeedViewHolder, position: Int) {
        viewHolder.bind(viewStates[position])
    }

    override fun getItemViewType(position: Int): Int {
        val viewState = viewStates[position]
        val type = viewState.type()
        return type.value()
    }

    fun setViewStates(viewStates: List<FeedViewState>) {
        this.viewStates.clear()
        this.viewStates.addAll(viewStates)
        notifyDataSetChanged()
    }

    override fun onViewRecycled(holder: FeedViewHolder) {
        holder.unbind()
    }

    interface Listener :
            AdViewHolder.Listener,
            TipViewHolder.Listener,
            QuestionsViewHolder.Listener,
            QuizViewHolder.Listener {

//        var NO_OP = object : Listener {
//            override fun onAdClicked(viewState: AdViewState) {
//                // no op
//            }
//
//            override fun onTipClicked(viewState: TipViewState) {
//                // no op
//            }
//
//            override fun onQuestionsClicked(viewState: QuestionsViewState) {
//                // no op
//            }
//
//            override fun onQuizClicked(viewState: QuizViewState) {
//                // no op
//            }
//        }
    }

}
