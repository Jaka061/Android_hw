package com.kay.progayim.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kay.progayim.data.models.Courses

@TypeConverters(TypeListConv::class)
@Database(entities = [Courses::class], version = 1)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun characterDao(): CourseDao
    abstract fun userDao(): UserDao

}