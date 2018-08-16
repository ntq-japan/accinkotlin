package vn.com.ntq_solution.data.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import vn.com.ntq_solution.data.database.entities.ApplicationEntity

/** The Data Accept Object's persisted the application entity from Room. */
@Dao
interface ApplicationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: ApplicationEntity)

    @Query("SELECT * FROM application ORDER BY id ASC LIMIT 1")
    fun load(): ApplicationEntity

    @Query("SELECT * FROM application ORDER BY id ASC LIMIT 1")
    fun subscribe(): LiveData<ApplicationEntity>
}
