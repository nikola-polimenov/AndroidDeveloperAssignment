package com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels

data class Events (
    var eventId: Int?,
    var period: String?,
    var time: String?,
    var optaMinute: Int?,
    var minute: Int?,
    var teamId: String?,
    var type: String?,
    var eventTimestamp: String?,
    var goalDetails: GoalDetails?,
    var bookingDetails: BookingDetails?,
    var substitutionDetails: SubstitutionDetails?,
    var teamImageUrl: String?
)