package com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters.EventsTypeConverter
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters.OfficialsTypeConverter

@Entity(tableName = "matches")
data class Data (
    var id: String?,
    var feedMatchId: Int?,
    var competition: String?,
    var competitionId: Int?,
    var status: String?,
    var period: String?,
    var seasonId: Int?,
    var season: String?,
    var round: Int?,
    var minute: Int?,
    var attendance: Int?,
    var date: String?,
    @Embedded(prefix = "homeTeam_")
    var homeTeam: HomeTeam?,
    @Embedded(prefix = "awayTeam_")
    var awayTeam: AwayTeam?,
    @Embedded(prefix = "venue_")
    var venue: Venue?,
    @TypeConverters(EventsTypeConverter::class)
    var events: ArrayList<Events>?,
    @TypeConverters(OfficialsTypeConverter::class)
    var officials: ArrayList<Officials>?
) {
    @PrimaryKey(autoGenerate = true)
    var matchId: Int = 0
}