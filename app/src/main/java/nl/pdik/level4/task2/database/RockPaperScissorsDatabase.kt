package nl.pdik.level4.task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nl.pdik.level4.task2.models.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class RockPaperScissorsDatabase : RoomDatabase() {

    abstract fun rockDao(): RockDao

    companion object {
        private const val DATABASE_NAME = "ROCK_PAPER_SCISSORS_DATABASE"

        @Volatile
        private var INSTANCE: RockPaperScissorsDatabase? = null

        fun getDatabase(context: Context): RockPaperScissorsDatabase? {
            if (INSTANCE == null) {
                synchronized(RockPaperScissorsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            RockPaperScissorsDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}