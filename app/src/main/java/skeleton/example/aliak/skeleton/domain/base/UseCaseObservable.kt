package skeleton.example.aliak.skeleton.domain.base

import com.aliak.dev.fastreading.domain.base.UseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import org.reactivestreams.Subscriber
import timber.log.Timber

/**
 * @author Alexandr Novik
 */
abstract class UseCaseObservable<in ParamType, ResultType> protected constructor(
        scheduler: Scheduler,
        postExecutionThread: Scheduler) : UseCase<ResultType>(scheduler, postExecutionThread) {

    abstract fun buildUseCase(param: ParamType): Observable<ResultType>

    open fun execute(param: ParamType, subscriber: Subscriber<ResultType>) {
        disposable = buildUseCase(param)
                .subscribeOn(scheduler)
                .observeOn(postExecutionThread)
                .subscribe { subscriber }
    }

    open fun execute(param: ParamType,
                     next: (value: ResultType) -> Unit,
                     error: (e: Throwable) -> Unit = { Timber.e(it.message) },
                     complete: () -> Unit = {}) {
        disposable = buildUseCase(param)
                .subscribeOn(scheduler)
                .observeOn(postExecutionThread)
                .subscribeWith(UseCaseSubscriber(next, error, complete))
    }
}