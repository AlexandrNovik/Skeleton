package com.aliak.dev.fastreading.domain.base

import com.aliak.dev.fastreading.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.Executor

/**
 * @author Aliaksandr Novik
 */
abstract class UseCase<ResultType> protected constructor(
        protected val scheduler: Scheduler,
        protected val postExecutionThread: Scheduler) {

    constructor(threadExecutor: Executor, postExecutionThread: PostExecutionThread)
            : this(Schedulers.from(threadExecutor), postExecutionThread.getScheduler())

    constructor(threadExecutor: Scheduler, postExecutionThread: PostExecutionThread)
            : this(threadExecutor, postExecutionThread.getScheduler())

    protected var disposable: Disposable = Disposables.empty()

    /**
     * Unsubscribe from current Subscription.
     */
    open fun unsubscribe() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

    class UseCaseSubscriber<ResultType>(private val next: (value: ResultType) -> Unit,
                                        private val error: (e: Throwable) -> Unit = { Timber.e(it.message) },
                                        private val complete: () -> Unit = {})
        : DisposableObserver<ResultType>() {
        override fun onError(e: Throwable) {
            e?.let { error(it) }
        }

        override fun onComplete() {
            complete()
        }

        override fun onNext(t: ResultType) {
            next(t)
        }
    }

}
