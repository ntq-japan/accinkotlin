package vn.com.ntq_solution.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.com.ntq_solution.di.support.ViewModelFactory
import vn.com.ntq_solution.di.support.ViewModelKey
import vn.com.ntq_solution.presenter.viewmodels.SplashViewModel

/**
 * The view model module configuration for dependency injection library - dagger.
 *
 * This class define the view model list.
 * Example:
 *  - @Binds @IntoMap @ViewModelKey(UserViewModel::class)
 *  - abstract fun bindUserViewModel(repoViewModel: UserViewModel): ViewModel
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
