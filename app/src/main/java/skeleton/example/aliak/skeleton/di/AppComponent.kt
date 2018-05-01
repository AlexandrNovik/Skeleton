package skeleton.example.aliak.skeleton.di

import dagger.Component
import skeleton.example.aliak.skeleton.SkeletonApp
import skeleton.example.aliak.skeleton.presentation.base.BaseActivity
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            DomainModule::class,
            RouterModule::class
        ])
interface AppComponent {
    fun inject(activity: SkeletonApp)
    fun inject(activity: BaseActivity)
}
