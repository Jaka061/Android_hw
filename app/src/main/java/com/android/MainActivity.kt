package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),OnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()
    }

    override fun onClickFragAuto() {
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment1)
            .addToBackStack(null).commit()
    }

    override fun onClickFragMenu() {
        val fragment2 = Fragment2()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }

    override fun onClickFragGl() {
        val fragment3 = Fragment3()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment3).commit()
    }
}
