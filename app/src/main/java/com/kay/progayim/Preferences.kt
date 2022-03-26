package com.kay.progayim

import android.content.Context

interface Preferences{

    fun saveLogin(key:String,value:String)

    fun savePassword(key:String,value:String)

    fun getLogin(key:String) : String

    fun getPassword(key:String) : String
}

class PreferencesImp(context: Context): Preferences{

    private val pref = context.getSharedPreferences("Logins",Context.MODE_PRIVATE)

    override fun saveLogin(key:String,value:String) {
        pref.edit().apply(){
            putString(key,value)
        }.apply()
    }

    override fun savePassword(key:String,value:String) {
        pref.edit().apply(){
            putString(key,value)
        }.apply()
    }

    override fun getLogin(key:String) : String {
        return pref.getString(key,"")?: ""
    }

    override fun getPassword(key:String) : String {
        return pref.getString(key,"")?: ""
    }

}