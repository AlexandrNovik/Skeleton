package skeleton.example.aliak.skeleton.presentation.base

import android.support.v7.app.AppCompatActivity
import skeleton.example.aliak.skeleton.MainRouter
import skeleton.example.aliak.skeleton.SkeletonApp
import javax.inject.Inject

open abstract class BaseActivity : AppCompatActivity() {
    @Inject protected lateinit var mainRouter: MainRouter

    init {
        SkeletonApp.appComponent.inject(this)
    }

}