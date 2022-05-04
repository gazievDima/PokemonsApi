package com.gaziev.data.models.converter

import android.media.Image
import androidx.room.TypeConverter
import com.gaziev.data.models.ImagesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterImagesEntity {

    @TypeConverter
    fun fromList(value: ImagesEntity): String {
        val gson = Gson()
        return gson.toJson(value, ImagesEntity::class.java)
    }

    @TypeConverter
    fun toList(value: String): ImagesEntity {
        val gson = Gson()
        return gson.fromJson(value, ImagesEntity::class.java)
    }
}