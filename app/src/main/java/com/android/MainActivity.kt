package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),OnClick {

    private val pref get() = Injector.preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(pref.getLogin("login").isNullOrEmpty() && pref.getPassword("password").isNullOrEmpty()){
            supportFragmentManager.beginTransaction()
                .add(R.id.frag_cont, FragRegistration()).commit()
        }
        else {
            supportFragmentManager.beginTransaction()
                .add(R.id.frag_cont, FragAutorization()).commit()
        }

    }

    override fun goToAutorization() {
        val fragment1 = FragAutorization()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment1)
            .commit()
    }

    override fun goToRegistr() {
        val fragment2 = FragRegistration()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2).commit()
    }

    override fun goToMenu(login: String) {
        val fragment3 = FragMenu()
        val bundle = Bundle()
        bundle.putString("textF",login)
        fragment3.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment3)
            .commit()
    }
}
