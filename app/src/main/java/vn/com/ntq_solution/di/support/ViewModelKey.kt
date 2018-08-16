package vn.com.ntq_solution.di.support

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/** The model key injection. */
@MapKey
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
