package skeleton.example.aliak.skeleton.di

import dagger.Component
import skeleton.example.aliak.skeleton.MainActivity
import skeleton.example.aliak.skeleton.SkeletonApp
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            DomainModule::class
        ])
interface AppComponent {
    fun inject(app: SkeletonApp)
    fun inject(activity: MainActivity)
}
