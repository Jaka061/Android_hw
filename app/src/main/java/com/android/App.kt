package com.android

import android.app.Application

class App : Application() {

    lateinit var preferences : Preferences

    override fun onCreate() {
        super.onCreate()
        instance1 = this
        preferences = PreferencesImp(this)
    }

    companion object{
        private var instance1 : App? = null
        val instance get() = instance1!!
    }
}

val Injector: App
    get() = App.instance