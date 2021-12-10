package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity(),OnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()
    }

    override fun onClickFrag1() {
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment1)
            .addToBackStack(null).commit()
    }

    override fun onClickFrag2() {
        val fragment2 = Fragment2()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }

    override fun onClickFrag3(login : String) {
        val fragment3 = Fragment3()
        val bundle = Bundle()
        bundle.putString("textF",login)
        fragment3.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment3)
            .addToBackStack(null).commit()
    }
}
