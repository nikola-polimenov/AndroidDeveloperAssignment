package com.nikola.assignment.models.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikola.assignment.models.matchmodels.Players

class PlayersTypeConverter {

    @TypeConverter
    fun fromString(value: String?): ArrayList<Players>? {
        if (value == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<Players>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Players>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}