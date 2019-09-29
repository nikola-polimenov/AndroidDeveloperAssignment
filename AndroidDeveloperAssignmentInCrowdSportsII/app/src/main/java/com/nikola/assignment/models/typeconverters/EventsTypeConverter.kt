package com.nikola.assignment.models.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikola.assignment.models.matchmodels.Events

class EventsTypeConverter {

    @TypeConverter
    fun fromString(value: String?): ArrayList<Events>? {
        if (value == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<Events>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Events>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

}