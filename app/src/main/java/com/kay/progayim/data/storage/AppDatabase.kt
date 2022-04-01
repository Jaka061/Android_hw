package com.kay.progayim.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kay.progayim.data.models.Characters

@TypeConverters(TypeListConv::class)
@Database(entities = [Characters::class], version = 1)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun characterDao(): CharacterDao

}