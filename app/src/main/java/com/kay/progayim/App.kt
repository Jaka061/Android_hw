package com.kay.progayim

import android.app.Application
import androidx.room.Room
import com.kay.progayim.database.AppDatabase
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var database: AppDatabase

    lateinit var breakingBadApi: BreakingBadApi

    override fun onCreate() {
        super.onCreate()
        mInstance = this

//        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
//            .fallbackToDestructiveMigration()
//            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        breakingBadApi = retrofit.create(BreakingBadApi::class.java)

    }

    companion object {
        const val BASE_URL = "https://breakingbadapi.com"

        private var mInstance: App? = null
        val instance get() = mInstance!!
    }
}

val Any.Injector: App
    get() = App.instance