package vn.com.ntq_solution.di.component

import dagger.BindsInstance
import dagger.Component
import vn.com.ntq_solution.app.MainApplication
import vn.com.ntq_solution.di.ActivityModule
import vn.com.ntq_solution.di.ApplicationModule
import javax.inject.Singleton

/**
 * The application main component configuration for dependency injection library - dagger.
 *
 * This class define building ways for application component and it's sub modules.
 */
@Singleton
@Component(modules = [ApplicationModule::class, ActivityModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MainApplication)
}
