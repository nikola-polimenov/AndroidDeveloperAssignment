package com.nikola.androiddeveloperassignmentincrowdsportsii.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Data
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters.EventsTypeConverter
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters.OfficialsTypeConverter
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters.PlayersTypeConverter
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters.TeamStatsTypeConverter


@Database(entities = [Data::class], version = 1, exportSchema = false)
@TypeConverters(PlayersTypeConverter::class, TeamStatsTypeConverter::class, EventsTypeConverter::class, OfficialsTypeConverter::class)
abstract class MatchDatabase: RoomDatabase() {
    abstract fun matchDAO(): MatchDAO


    companion object {
        @Volatile
        var database: MatchDatabase? = null

        fun getInstance(context: Context): MatchDatabase? {
            if (database == null) {
                synchronized(MatchDatabase::class.java) {
                    if (database == null) {
                        database = Room.databaseBuilder(context.applicationContext, MatchDatabase::class.java, "matchDatabase")
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return database
        }

    }


}