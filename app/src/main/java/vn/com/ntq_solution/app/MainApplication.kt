package vn.com.ntq_solution.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import vn.com.ntq_solution.di.component.ApplicationComponent
import vn.com.ntq_solution.di.component.DaggerApplicationComponent
import vn.com.ntq_solution.domain.loggings.Logcat
import javax.inject.Inject

/**
 * Main application class.
 * This class alive as long as the application process do. On this class have some domain task
 * listed up bellow:
 *  - Store the application instance by static.
 *  - Implement the dagger injection.
 */
abstract class MainApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        private lateinit var INSTANCE: MainApplication

        /** The singleton implement to get the main application instance by late init keyword. */
        fun getInstance(): MainApplication {
            return INSTANCE
        }

        class MainActivityLifecycleCallbacks : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName, "onActivityPaused", "LifecycleCallbacks")
                }
            }

            override fun onActivityResumed(activity: Activity?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName, "onActivityResumed", "LifecycleCallbacks")
                }
            }

            override fun onActivityStarted(activity: Activity?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName, "onActivityStarted", "LifecycleCallbacks")
                }
            }

            override fun onActivityDestroyed(activity: Activity?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName, "onActivityDestroyed", "LifecycleCallbacks")
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity?, bundle: Bundle?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName,
                            "onActivitySaveInstanceState", "LifecycleCallbacks")
                }
            }

            override fun onActivityStopped(activity: Activity?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName, "onActivityStopped", "LifecycleCallbacks")
                }
            }

            override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
                if (activity != null) {
                    Logcat.d(activity.localClassName, "onActivityCreated", "LifecycleCallbacks")
                    if (activity is BaseDaggerActivity) {
                        AndroidInjection.inject(activity)
                        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                                object : FragmentManager.FragmentLifecycleCallbacks() {
                                    override fun onFragmentCreated(
                                            fm: FragmentManager?, f: Fragment?, state: Bundle?) {
                                        super.onFragmentCreated(fm, f, state)
                                        if (f != null) {
                                            AndroidSupportInjection.inject(f);
                                        }
                                    }
                                }, true)
                    }
                }
            }
        }
    }

    private val dependencyInjection: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().application(this).build()
    }

    private val mainActivityLifecycleCallbacks = MainActivityLifecycleCallbacks()

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        // Inject the dagger dependency to project
        dependencyInjection.inject(this)

        // Register the activity lifecycle callbacks for injection and permission
        registerActivityLifecycleCallbacks(mainActivityLifecycleCallbacks)
    }

    override fun onTerminate() {
        super.onTerminate()

        // Unregister the activity lifecycle callbacks for abandon memory leak
        unregisterActivityLifecycleCallbacks(mainActivityLifecycleCallbacks)
    }
}
