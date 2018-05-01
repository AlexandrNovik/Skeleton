package com.aliak.dev.fastreading.domain.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

/**
 * @author Aliaksandr Novik
 */
@Singleton
class UIThread : PostExecutionThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}