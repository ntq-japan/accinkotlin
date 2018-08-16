package vn.com.ntq_solution.data.converter

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * The database time converter convert from JSON String datetime format to the Date class.
 */
object DateConverter {
    /**
     * Convert the timestamp string in datetime format to the Date class.
     *
     * @param timestamp The timestamp string with datetime format.
     * @return Converted Date class or null.
     */
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    /**
     * Convert the Date class data to the timestamp string in datetime format.
     *
     * @param date The Date class.
     * @return Converted timestamp string in datetime format or null.
     */
    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}
