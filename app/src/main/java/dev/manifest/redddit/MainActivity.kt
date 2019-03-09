package dev.manifest.redddit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    /**
     * Finish activity when reaching the last fragment.
     */
    override fun onBackPressed() {
        super.onBackPressed()
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 1) fm.popBackStack() else finish()
    }

    fun changeFragment(fragment: Fragment, cleanBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (cleanBackStack) clearBackStack()
        fragmentTransaction.setCustomAnimations(
            R.anim.abc_fade_in,
            R.anim.abc_fade_out,
            R.anim.abc_popup_enter,
            R.anim.abc_popup_exit
        )
        fragmentTransaction.replace(R.id.activity_base_content, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun clearBackStack() {
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 0) {
            val firstEntry = fm.getBackStackEntryAt(0)
            fm.popBackStack(firstEntry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
