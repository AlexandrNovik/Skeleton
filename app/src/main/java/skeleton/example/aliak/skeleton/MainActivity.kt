package skeleton.example.aliak.skeleton

import android.os.Bundle
import skeleton.example.aliak.skeleton.presentation.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainRouter.openMainFragment(this)
    }
}
