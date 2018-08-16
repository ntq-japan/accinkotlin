package vn.com.ntq_solution.data.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Disk cache for Application information. (Always be the data class)
 *
 * Note: An entity must have at least 1 field annotated with @PrimaryKey.
 */
@Entity(tableName = "application")
data class ApplicationEntity(@PrimaryKey val id: String, var version: String)
