package vn.com.ntq_solution.presenter.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import vn.com.ntq_solution.data.database.entities.ApplicationEntity
import vn.com.ntq_solution.data.repository.ApplicationRepository
import javax.inject.Inject

/**
 * The Splash ViewModel provides the data for a Splash fragment UI component and handles
 * the communication with the business part of data handling, such as calling other components
 * to load the data or forwarding user modifications. The ViewModel does not know about the View
 * and is not affected by configuration changes such as recreating an activity due to rotation.
 */
class SplashViewModel @Inject constructor(
        private val applicationRepository: ApplicationRepository) : ViewModel() {
    /** Get the application live data. */
    fun subscribeApplication(): LiveData<ApplicationEntity> {
        return applicationRepository.subscribeApplication()
    }

    /**
     * Request update the application version number.
     *
     * @param version The application number.
     */
    fun updateApplicationVersion(version: String) {
        applicationRepository.updateApplicationVersion(version)
    }
}
