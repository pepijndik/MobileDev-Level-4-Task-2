package nl.pdik.level4.task2.database

import androidx.room.TypeConverter
import nl.pdik.level4.task2.models.GameMove
import nl.pdik.level4.task2.models.GameResult
import java.util.*

class Converters {
    @TypeConverter
    fun dateFromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun stringToGameResult(value: String) = enumValueOf<GameResult>(value)

    @TypeConverter
    fun fromGameResult(value: GameResult) = value.name

    @TypeConverter
    fun stringToGameMove(value: String) = enumValueOf<GameMove>(value)

    @TypeConverter
    fun fromGameMove(value: GameMove) = value.name
}