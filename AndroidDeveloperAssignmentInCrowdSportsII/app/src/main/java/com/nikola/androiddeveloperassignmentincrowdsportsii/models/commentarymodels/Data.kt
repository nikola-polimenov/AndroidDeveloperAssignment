package com.nikola.androiddeveloperassignmentincrowdsportsii.models.commentarymodels

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
    var commentaryEntries: ArrayList<CommentaryEntry>?
)