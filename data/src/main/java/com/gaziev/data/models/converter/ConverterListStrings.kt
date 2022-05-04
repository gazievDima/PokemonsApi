package com.gaziev.data.models.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterListStrings {

    @TypeConverter
    fun fromList(value: List<String>?): String {
        if (value != null) {
            val gson = Gson()
            val type = object : TypeToken<List<String>>() {}.type
            return gson.toJson(value, type)
        } else {
            return ""
        }
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        if (value.isNotEmpty()) {
            val gson = Gson()
            val type = object : TypeToken<List<String>>() {}.type
            return gson.fromJson(value, type)
        } else {
            return emptyList()
        }
    }
}