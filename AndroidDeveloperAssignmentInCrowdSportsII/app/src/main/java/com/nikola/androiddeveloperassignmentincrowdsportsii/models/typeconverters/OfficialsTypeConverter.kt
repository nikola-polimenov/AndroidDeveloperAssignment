package com.nikola.androiddeveloperassignmentincrowdsportsii.models.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Officials

class OfficialsTypeConverter {

    @TypeConverter
    fun fromString(value: String?): ArrayList<Officials>? {
        if (value == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<Officials>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Officials>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

}