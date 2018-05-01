package skeleton.example.aliak.skeleton.di

import com.aliak.dev.fastreading.domain.executor.JobExecutor
import com.aliak.dev.fastreading.domain.executor.PostExecutionThread
import com.aliak.dev.fastreading.domain.executor.ThreadExecutor
import com.aliak.dev.fastreading.domain.executor.UIThread
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import skeleton.example.aliak.skeleton.domain.executor.HandlerThreadScheduler
import javax.inject.Named
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideThreadExecutor(): ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    @Named("threadExecution")
    fun provideThreadScheduler(e: ThreadExecutor): Scheduler {
        return Schedulers.from(e)
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread {
        return UIThread()
    }

    @Provides
    @Singleton
    @Named("uiExecution")
    fun providePostExecutionScheduler(): Scheduler {
        return UIThread().getScheduler()
    }

    @Provides
    @Singleton
    @Named("realmExecution")
    fun provideDatabaseScheduler(): Scheduler {
        return HandlerThreadScheduler("realm")
    }
}