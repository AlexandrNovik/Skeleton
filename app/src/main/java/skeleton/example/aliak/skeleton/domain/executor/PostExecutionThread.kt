package com.aliak.dev.fastreading.domain.executor

import io.reactivex.Scheduler

/**
 * @author Aliaksandr Novik
 */
interface PostExecutionThread {
    fun getScheduler(): Scheduler
}