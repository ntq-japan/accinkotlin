package vn.com.ntq_solution.data.repository

import android.arch.lifecycle.LiveData
import vn.com.ntq_solution.data.AppExecutors
import vn.com.ntq_solution.data.database.dao.ApplicationDao
import vn.com.ntq_solution.data.database.entities.ApplicationEntity
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Repository for application entity.
 *
 * Repository modules are responsible for handling data operations. They provide a clean API to
 * the rest of the app. They know where to get the data from and what API calls to make when data
 * is updated. You can consider them as mediators between different data sources.
 * (persistent model, web service, cache, etc.).
 */
@Singleton
class ApplicationRepository @Inject constructor(
        private val dao: ApplicationDao, private val executors: AppExecutors) {
    /** Get the application live data. */
    fun subscribeApplication(): LiveData<ApplicationEntity> {
        return dao.subscribe()
    }

    /**
     * Request update the application version number.
     *
     * @param version The application number.
     */
    fun updateApplicationVersion(version: String) = executors.diskIO.execute {
        val applicationEntity = dao.load()
        if (applicationEntity.version < version) {
            applicationEntity.version = version
            dao.save(applicationEntity)
        }
    }
}