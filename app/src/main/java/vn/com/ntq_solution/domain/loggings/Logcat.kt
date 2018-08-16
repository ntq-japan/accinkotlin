package vn.com.ntq_solution.domain.loggings

import android.util.Log
import vn.com.ntq_solition.app.BuildConfig
import vn.com.ntq_solution.domain.utils.Typography

/** Default log manager control the logging communicate with adb logcat drive. */
class Logcat {
    companion object {
        /** Current class name. */
        private val CLASS_NAME = Logcat::class.java.name

        /** Debug flag. If the debug flag is true, send the log to adb. */
        private const val ENABLE_VERBOSE = BuildConfig.BUILD_TYPE == "debug"

        /** Current application root package name. */
        private const val ROOT_PACKAGE = BuildConfig.APPLICATION_ID

        /** Log method flow type. */
        private const val LOG_TYPE_FLOW = BuildConfig.FLAVOR + ".flow"

        /** Log method information type. */
        private const val LOG_TYPE_INFO = BuildConfig.FLAVOR + ".info"

        /**
         * Count the stack index and add it to the builder with the method name.

         * @param builder The String builder.
         * @param className The called class name.
         * @param methodName The called method name.
         *
         * @return The String builder's added data.
         */
        private fun getIndexMethodBuilder(builder: StringBuilder, className: String,
                                          methodName: String): StringBuilder {
            // Get the current thread
            val currentThread = Thread.currentThread()

            // Stack index counting
            val stackTrace = currentThread.stackTrace
            for (traceElement in stackTrace) {
                val traceName = traceElement.className
                // Check class name from this application except this class
                if (traceName != null
                        && !traceName.contains(CLASS_NAME)
                        && traceName.contains(ROOT_PACKAGE)) {
                    // Input double '-' index
                    builder.append(Typography.HYPHEN)
                    builder.append(Typography.HYPHEN)
                }
            }

            // Get current thread name
            val threadName = currentThread.name

            // Update message of method tag
            builder.append(Typography.DOLLAR)
            builder.append(threadName)
            builder.append(Typography.SPACE)
            builder.append(className.replace(ROOT_PACKAGE, ""))
            builder.append(Typography.DOT)
            builder.append(methodName)
            builder.append(Typography.SPACE)

            return builder
        }

        /**
         * Write the log. (log when starting method)

         * @param className The called class name.
         * @param methodName The called method name.
         */
        fun enter(className: String, methodName: String) {
            // Create log tag ID
            val tagBuilder = StringBuilder(Typography.SHARP)

            // Input log thread index builder with name
            getIndexMethodBuilder(tagBuilder, className, methodName)

            // Enter log flag
            tagBuilder.append(Typography.CURLY_BRACKET_OPEN)

            // Send log to adb
            Log.d(LOG_TYPE_FLOW, tagBuilder.toString())
        }

        /**
         * Write debug log message.

         * @param className Name of the calling class.
         * @param methodName Name of the calling method.
         * @param msg Debug message.
         */
        fun d(className: String, methodName: String, msg: String) {
            // Create log tag id
            val tagBuilder = StringBuilder(Typography.SHARP)

            // Input log thread index builder with name
            getIndexMethodBuilder(tagBuilder, className, methodName)

            // Add message log
            tagBuilder.append(Typography.DOUBLE_DOT)
            tagBuilder.append(Typography.SPACE)
            tagBuilder.append(msg)

            // Send log to adb
            Log.d(LOG_TYPE_INFO, tagBuilder.toString())
        }

        /**
         * Write error log message.

         * @param className Name of the calling class.
         * @param methodName Name of the calling method.
         * @param msg Error message.
         */
        fun e(className: String, methodName: String, msg: String) {
            // Create log tag id
            val tagBuilder = StringBuilder(Typography.SHARP)

            // Input log thread index builder with name
            getIndexMethodBuilder(tagBuilder, className, methodName)

            // Add message log
            tagBuilder.append(Typography.DOUBLE_DOT)
            tagBuilder.append(Typography.SPACE)
            tagBuilder.append(msg)

            // Send log to adb
            Log.e(LOG_TYPE_INFO, tagBuilder.toString())
        }

        /**
         * Write information log message.

         * @param className Name of the calling class.
         * @param methodName Name of the calling method.
         * @param msg Information message.
         */
        fun i(className: String, methodName: String, msg: String) {
            // When debug is true, send debug log level to adb
            if (ENABLE_VERBOSE) {
                // Create log tag id
                val tagBuilder = StringBuilder(Typography.SHARP)

                // Input log thread index builder with name
                getIndexMethodBuilder(tagBuilder, className, methodName)

                // Add message log
                tagBuilder.append(Typography.DOUBLE_DOT)
                tagBuilder.append(Typography.SPACE)
                tagBuilder.append(msg)

                // Send log to adb
                Log.i(LOG_TYPE_INFO, tagBuilder.toString())
            }
        }

        /**
         * Write warning log message.

         * @param className Name of the calling class.
         * @param methodName Name of the calling method.
         * @param msg Warning message.
         */
        fun w(className: String, methodName: String, msg: String) {
            // Create log tag id
            val tagBuilder = StringBuilder(Typography.SHARP)

            // Input log thread index builder with name
            getIndexMethodBuilder(tagBuilder, className, methodName)

            // Add message log
            tagBuilder.append(Typography.DOUBLE_DOT)
            tagBuilder.append(Typography.SPACE)
            tagBuilder.append(msg)

            // Send log to adb
            Log.w(LOG_TYPE_INFO, tagBuilder.toString())
        }

        /**
         * Write log. (Log when a method end)

         * @param className Name of the calling class.
         * @param methodName Name of the calling method.
         */
        fun exit(className: String, methodName: String) {
            // Create log tag id
            val tagBuilder = StringBuilder(Typography.SHARP)

            // Input log thread index builder with name
            getIndexMethodBuilder(tagBuilder, className, methodName)

            // Exit log flag
            tagBuilder.append(Typography.CURLY_BRACKET_CLOSE)

            // Send log to adb
            Log.d(LOG_TYPE_FLOW, tagBuilder.toString())
        }
    }
}
