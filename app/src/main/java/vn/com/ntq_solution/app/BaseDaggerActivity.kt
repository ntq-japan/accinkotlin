package vn.com.ntq_solution.app

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Base activity supported dagger dependency injection.
 *
 * This activity implement HasSupportFragmentInjector for inject the fragment dependency into it.
 * The dependency injection task will be automatically add to dagger graph.
 */
@SuppressLint("Registered")
open class BaseDaggerActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
