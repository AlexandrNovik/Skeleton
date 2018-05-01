package skeleton.example.aliak.skeleton

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import skeleton.example.aliak.skeleton.presentation.main.MainFragment

class MainRouter {
    fun openMainFragment(activity: FragmentActivity) {
        val fragmentManager = activity.supportFragmentManager
        var fragment = fragmentManager.findFragment(MainFragment.TAG)

        if (fragment == null || !fragment.isAdded) {
            fragment = MainFragment()

            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, fragment, MainFragment.TAG)
                    .commit()
        }
    }

    private fun FragmentManager.findFragment(tag: String): Fragment? {
        this.executePendingTransactions()
        return this.findFragmentByTag(tag)
    }
}