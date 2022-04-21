package com.kay.progayim

import android.app.Application
import androidx.room.Room
import com.kay.progayim.data.network.OnlineCoursesApi
import com.kay.progayim.database.AppDatabase
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var database: AppDatabase
    lateinit var api: OnlineCoursesApi

    override fun onCreate() {
        super.onCreate()

        mInstance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(COURSES_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(OnlineCoursesApi::class.java)
    }

    companion object {

        const val COURSES_URL = "https://localhostЖ8080/api/registration"

        private var mInstance: App? = null
        val instance get() = mInstance!!
    }
}

val Injector: App
    get() = App.instance
