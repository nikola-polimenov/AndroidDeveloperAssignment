package com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.TeamStats

class TeamStatsTypeConverter {
    @TypeConverter
    fun fromString(value: String?): TeamStats {
        if (value == null) {
            return TeamStats()
        }
        val teamStatsObject = object : TypeToken<TeamStats>() {

        }.type
        return Gson().fromJson(value, teamStatsObject)
    }

    @TypeConverter
    fun fromObject(teamStatsObject: TeamStats?): String? {
        val gson = Gson()
        return gson.toJson(teamStatsObject)
    }
}