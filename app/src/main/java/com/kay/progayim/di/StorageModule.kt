package com.kay.progayim.di

import android.app.Application
import androidx.room.Room
import com.kay.progayim.data.storage.AppDatabase
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn
class StorageModule : Application(){

    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()

    }
}