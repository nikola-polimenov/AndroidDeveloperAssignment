package com.nikola.assignment.room

import androidx.room.*
import com.nikola.assignment.models.matchmodels.Data

@Dao
interface MatchDAO {

    @Query("SELECT * FROM matches WHERE feedMatchId LIKE :feedMatchId")
    suspend fun findMatch(feedMatchId: Int?): Data

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: Data?)

    @Delete
    suspend fun deleteMatch(match: Data?)

}