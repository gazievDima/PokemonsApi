package com.gaziev.data.models.converters

import androidx.room.TypeConverter
import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.models.ImagesRemoteEntity
import com.google.gson.Gson

class ImagesLocalEntityConverter {

    @TypeConverter
    fun fromList(value: ImagesLocalEntity): String {
        val gson = Gson()
        return gson.toJson(value, ImagesLocalEntity::class.java)
    }

    @TypeConverter
    fun toList(value: String): ImagesLocalEntity {
        val gson = Gson()
        return gson.fromJson(value, ImagesLocalEntity::class.java)
    }
}