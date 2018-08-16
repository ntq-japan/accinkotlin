package vn.com.ntq_solution.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.com.ntq_solition.app.BuildConfig
import vn.com.ntq_solution.data.AppExecutors
import vn.com.ntq_solution.data.database.MainDatabase
import vn.com.ntq_solution.data.database.dao.ApplicationDao
import vn.com.ntq_solution.data.network.Webservice
import vn.com.ntq_solution.data.repository.ApplicationRepository
import javax.inject.Singleton

/**
 * The application main module configuration for dependency injection library - dagger.
 *
 * This class define the sub module list of application module.
 * Example:
 *  - DATABASE INJECTION
 *  - @Provides @Singleton
 *  - fun provideUserDao(database: MainDatabase): UserDao {return database.userDao())}
 *
 *  - REPOSITORY INJECTION
 *  - @Provides @Singleton
 *  - fun provideUserRepository(
 *  -     webservice: Webservice, userDao: UserDao, executor: Executor): UserRepository {
 *  -         return UserRepository(webservice, userDao, executor)
 *  - }
 */
@Module(includes = [ViewModelModule::class])
class ApplicationModule {
    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): Webservice {
        return restAdapter.create<Webservice>(Webservice::class.java)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.WEB_API).build()
    }

    // --- DATABASE INJECTION ---
    @Provides
    @Singleton
    fun provideDatabase(): MainDatabase {
        return MainDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideApplicationDao(database: MainDatabase): ApplicationDao {
        return database.applicationDao()
    }

    // --- REPOSITORY INJECTION ---
    @Provides
    fun provideExecutor(): AppExecutors {
        return AppExecutors()
    }

    @Provides
    @Singleton
    fun provideUserRepository(
            applicationDao: ApplicationDao, executors: AppExecutors): ApplicationRepository {
        return ApplicationRepository(applicationDao, executors)
    }
}
