package com.kay.progayim.data.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.kay.progayim.data.models.Location

class TypeListConv {

    @TypeConverter
    fun listToJson(value : List<String>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value,Array<String>::class.java).toList()

    @TypeConverter
    fun locationToJson(value : Location) = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String) = Gson().fromJson(value,Location::class.java)
}