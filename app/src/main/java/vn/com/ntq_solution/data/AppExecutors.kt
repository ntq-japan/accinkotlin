package vn.com.ntq_solution.data

import android.os.Handler
import android.os.Looper
import vn.com.ntq_solition.app.BuildConfig
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Global executor pools for the whole application.
 *
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 */
class AppExecutors(val diskIO: Executor, val networkIO: Executor, val mainThread: Executor) {
    constructor() : this(Executors.newSingleThreadExecutor(),
            Executors.newFixedThreadPool(BuildConfig.API_REQUEST_POOL_SIZE), MainThreadExecutor())
    companion object {
        class MainThreadExecutor : Executor {
            private val mainThreadHandler = Handler(Looper.getMainLooper())

            override fun execute(command: Runnable) {
                mainThreadHandler.post(command)
            }
        }
    }
}
