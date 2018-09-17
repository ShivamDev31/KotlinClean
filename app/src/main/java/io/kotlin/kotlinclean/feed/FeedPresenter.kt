package io.kotlin.kotlinclean.feed

import io.kotlin.kotlinclean.feed.viewstate.AdViewState
import io.kotlin.kotlinclean.feed.viewstate.QuestionsViewState
import io.kotlin.kotlinclean.feed.viewstate.QuizViewState
import io.kotlin.kotlinclean.feed.viewstate.TipViewState
import io.kotlin.kotlinclean.navigator.Navigator
import io.reactivex.disposables.Disposables

class FeedPresenter(private val displayer: FeedDisplayer, private val useCase: FeedUseCase, private val navigator: Navigator) {

    companion object {
        fun create(displayer: FeedDisplayer, useCase: FeedUseCase, navigator: Navigator): FeedPresenter {
            return FeedPresenter(displayer, useCase, navigator)
        }
    }

    val listener = object : FeedView.Listener {
        override fun onAdClicked(viewState: AdViewState) {
            navigator.toAdDetail()
        }

        override fun onTipClicked(viewState: TipViewState) {
            navigator.toTipDetail()
        }

        override fun onQuestionsClicked(viewState: QuestionsViewState) {
            navigator.toQuestionsDetail()
        }

        override fun onQuizClicked(viewState: QuizViewState) {
            navigator.toQuizDetail()
        }

    }

    private var disposable = Disposables.empty()

    fun startPresenting() {
        disposable = useCase.healthFeed()
                .subscribe {
                    displayer.show(it)
                }
        displayer.setListener(listener)
    }

    fun stopPresenting() {
        disposable.dispose()
    }

}
