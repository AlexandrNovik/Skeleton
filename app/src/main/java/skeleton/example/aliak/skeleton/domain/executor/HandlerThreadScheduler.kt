package skeleton.example.aliak.skeleton.domain.executor

import android.os.HandlerThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class HandlerThreadScheduler(name: String) : Scheduler() {
    private val handlerThread = HandlerThread("android_handler_thread_$name")

    init {
        handlerThread.start()
    }

    override fun createWorker(): Worker {
        return AndroidSchedulers.from(handlerThread.looper).createWorker()
    }
}