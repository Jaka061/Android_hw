package com.kay.progayim.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kay.progayim.data.models.User

@Database(entities = [User::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}