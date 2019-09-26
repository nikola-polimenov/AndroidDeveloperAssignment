package com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels

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
    var homeTeam: HomeTeam?,
    var awayTeam: AwayTeam?,
    var venue: Venue?,
    var events: ArrayList<Events>?,
    var officials: ArrayList<Officials>?
)