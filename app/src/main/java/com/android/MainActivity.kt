package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), onBtnClicked {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag1,Fragment1()).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frag2,Fragment2()).commit()

    }
    override fun setText1(enterText: String) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.frag2) as? Fragment2
        fragment2?.setText2(enterText)
    }

}
