package com.kay.progayim.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}