package com.nikola.assignment.models.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikola.assignment.models.commentarymodels.CommentaryEntry

class CommentaryEntriesTypeConverter {

    @TypeConverter
    fun fromString(value: String?): ArrayList<CommentaryEntry>? {
        if (value == null) {
            return arrayListOf()
        }
        val listType = object : TypeToken<ArrayList<CommentaryEntry>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<CommentaryEntry>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

}