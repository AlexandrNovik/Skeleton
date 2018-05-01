package skeleton.example.aliak.skeleton

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import skeleton.example.aliak.skeleton.di.AppComponent
import skeleton.example.aliak.skeleton.di.AppModule
import skeleton.example.aliak.skeleton.di.DaggerAppComponent

class SkeletonApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}