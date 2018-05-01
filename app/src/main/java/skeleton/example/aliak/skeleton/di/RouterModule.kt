package skeleton.example.aliak.skeleton.di

import dagger.Module
import dagger.Provides
import skeleton.example.aliak.skeleton.MainRouter
import javax.inject.Singleton

@Module
class RouterModule {
    @Singleton
    @Provides
    fun provideMainRouter(): MainRouter = MainRouter()

}