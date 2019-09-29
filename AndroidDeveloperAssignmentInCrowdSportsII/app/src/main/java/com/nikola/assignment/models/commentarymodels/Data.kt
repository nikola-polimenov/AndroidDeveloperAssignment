package com.nikola.assignment.models.commentarymodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nikola.assignment.models.typeconverters.CommentaryEntriesTypeConverter

@Entity(tableName = "commentaries")
data class Data (
    var id: String?,
    var feedMatchId: Int?,
    var homeTeamName: String?,
    var homeTeamId: String?,
    var homeScore: Int?,
    var awayTeamName: String?,
    var awayTeamId: String?,
    var awayScore: Int?,
    var competitionId: Int?,
    var competition: String?,
    @TypeConverters(CommentaryEntriesTypeConverter::class)
    var commentaryEntries: ArrayList<CommentaryEntry>?
){
    @PrimaryKey(autoGenerate = true)
    var commentaryId: Int = 0
}