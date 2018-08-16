package vn.com.ntq_solution.di.submodule

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.com.ntq_solution.app.fragments.SplashFragment

/**
 * The fragment module configuration for dependency injection library - dagger.
 *
 * This class define the fragment list.
 * Example:
 *  - @ContributesAndroidInjector
 *  - abstract fun contributeUserFragment(): UserFragment
 */
@Module
abstract class SplashActivitySubmodule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment
}
