package vn.com.ntq_solution.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import vn.com.ntq_solution.app.MainApplication
import vn.com.ntq_solution.data.converter.DateConverter
import vn.com.ntq_solution.data.database.dao.ApplicationDao
import vn.com.ntq_solution.data.database.entities.ApplicationEntity

/**
 * Application main database base on Google Android Room database.
 *
 * This database defined a list of entity class for building data schema.
 * Example:
 *  - Entities list: @Database(entities = arrayOf(User::class), version = 1)
 *  - DAO list: abstract fun userDao(): UserDao
 */
@Database(entities = [ApplicationEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MainDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "main.db"
        private val INSTANCE = Room.databaseBuilder(MainApplication.getInstance(),
                MainDatabase::class.java, DATABASE_NAME).build()

        /** The singleton implement to get the Database instance. */
        fun getInstance(): MainDatabase {
            return INSTANCE
        }
    }

    abstract fun applicationDao(): ApplicationDao
}
