package com.nikola.assignment.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nikola.assignment.models.matchmodels.Data
import com.nikola.assignment.models.typeconverters.*


@Database(
    entities = [Data::class, com.nikola.assignment.models.commentarymodels.Data::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(
    PlayersTypeConverter::class,
    TeamStatsTypeConverter::class,
    EventsTypeConverter::class,
    OfficialsTypeConverter::class,
    CommentaryEntriesTypeConverter::class
)
abstract class MatchDatabase : RoomDatabase() {
    abstract fun matchDAO(): MatchDAO
    abstract fun commentaryDAO(): CommentaryDAO

    companion object {
        @Volatile
        var database: MatchDatabase? = null

        fun getInstance(context: Context): MatchDatabase? {
            if (database == null) {
                synchronized(MatchDatabase::class.java) {
                    if (database == null) {
                        database = Room.databaseBuilder(
                            context.applicationContext,
                            MatchDatabase::class.java,
                            "matchDatabase"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return database
        }

    }


}