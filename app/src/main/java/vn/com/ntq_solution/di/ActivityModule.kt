package vn.com.ntq_solution.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.com.ntq_solution.app.activities.SplashActivity
import vn.com.ntq_solution.di.submodule.SplashActivitySubmodule

/**
 * The activity module configuration for dependency injection library - dagger.
 *
 * This class define the activity list.
 * Example:
 *  - @ContributesAndroidInjector(modules = arrayOf(SplashActivitySubmodule::class))
 *  - abstract fun contributeMainActivity(): MainActivity
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [SplashActivitySubmodule::class])
    abstract fun contributeSplashActivity(): SplashActivity
}
