package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnBtnClicked {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()

    }
    override fun setText1(enterText: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("text",enterText)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,fragment2)
            .addToBackStack(null)
            .commit()
    }

}
