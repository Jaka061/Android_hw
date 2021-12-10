package com.android

import android.app.Application

class App : Application() {

    lateinit var preferences : Preferences

    override fun onCreate() {
        super.onCreate()
        _instance = this
        preferences = PreferencesImp(this)
    }

    companion object{
        private var _instance : App? = null
        val instance get() = _instance!!
    }
}

val Any.Injector: App
    get() = App.instance