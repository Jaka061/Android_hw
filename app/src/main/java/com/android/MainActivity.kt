package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),OnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,AutorizationFragment()).commit()
    }

    override fun onClickFragMenu() {
        val fragment2 = AboutMeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }

    override fun onClickFragGl() {
        val fragment3 = MenuFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment3).commit()
    }
}
