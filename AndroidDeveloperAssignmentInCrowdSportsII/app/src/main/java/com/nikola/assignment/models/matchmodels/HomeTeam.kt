package com.nikola.assignment.models.matchmodels

import androidx.room.TypeConverters
import com.nikola.assignment.models.typeconverters.PlayersTypeConverter
import com.nikola.assignment.models.typeconverters.TeamStatsTypeConverter


data class HomeTeam(
    var id: String? = "",
    var name: String? = "",
    var shortName: String? = "",
    var score: Int? = 0,
    var halfTimeScore: Int? = 0,
    @TypeConverters(PlayersTypeConverter::class)
    var players: ArrayList<Players>? = ArrayList(),
    @TypeConverters(TeamStatsTypeConverter::class)
    var teamStats: TeamStats? = TeamStats(),
    var imageUrl: String? = "",
    var feedMatchId: Int? = 0
)