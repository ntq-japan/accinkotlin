package vn.com.ntq_solution.app.activities

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import vn.com.ntq_solution.app.BaseDaggerActivity
import vn.com.ntq_solition.app.R
import vn.com.ntq_solution.app.fragments.SplashFragment

/**
 * Loading screen.
 *
 * Splash activity always run first when application started. It loading required packages and
 * showing the application logo animation.
 */
class SplashActivity : BaseDaggerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(toolbar)
        showMainFragment(savedInstanceState)
    }

    /**
     * Show the 
     */
    private fun showMainFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.placeholder, SplashFragment.newInstance(), null).commit()
        }
    }
}
