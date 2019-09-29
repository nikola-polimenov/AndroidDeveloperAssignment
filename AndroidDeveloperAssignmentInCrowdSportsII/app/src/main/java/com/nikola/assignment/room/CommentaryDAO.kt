package com.nikola.assignment.room

import androidx.room.*
import com.nikola.assignment.models.commentarymodels.Data

@Dao
interface CommentaryDAO {

    @Query("SELECT * FROM commentaries WHERE feedMatchId LIKE :feedMatchId")
    suspend fun findCommentary(feedMatchId: Int?): Data

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommentary(commentary: Data?)

    @Delete
    suspend fun deleteCommentary(commentary: Data?)

}