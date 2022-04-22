package com.kay.progayim

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.viewbinding.BuildConfig
import com.kay.progayim.data.network.OnlineCoursesApi
import com.kay.progayim.database.AppDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class App : Application() {

    private val isDebug get() = BuildConfig.DEBUG
    lateinit var api : OnlineCoursesApi
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()

        mInstance = this

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(App.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(App.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(App.TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor())
            .addInterceptor(httpHeaderLoggingInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(App.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(OnlineCoursesApi::class.java)
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(logger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("OkHttp_body", message)
            }
        }).setLevel(if (isDebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    private fun httpHeaderLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(logger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("OkHttp_header", message)
            }
        }).setLevel(if (isDebug) HttpLoggingInterceptor.Level.HEADERS else HttpLoggingInterceptor.Level.NONE)
    }

    companion object {
        const val BASE_URL = "https://localhost:8080/api/"
        const val TIMEOUT = 300L
        private var mInstance: App? = null
        val instance get() = mInstance!!
    }

}

val Any.Injector: App
    get() = App.instance