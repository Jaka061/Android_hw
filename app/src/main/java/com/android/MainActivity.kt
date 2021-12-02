package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// от .idea файлов нужно избавиться

class MainActivity : AppCompatActivity(), onBtnClicked {
 // remove line (пустая лишняя строка)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag1,Fragment1()).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frag2,Fragment2()).commit()

// remove line
    }
    override fun setText1(enterText: String) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.frag2) as? Fragment2
        fragment2?.setText2(enterText)
    } // add line
    override fun setText2(enterText: String) {
        val fragment1 = supportFragmentManager.findFragmentById(R.id.frag1) as? Fragment1
        fragment1?.setText(enterText)
    }

}
