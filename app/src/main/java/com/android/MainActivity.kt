package com.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

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
        bundle.putString("textF",enterText)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }

    override fun onClick(txtAct: String){
        val intent = Intent("myActivity2")
        intent.putExtra("text", txtAct)
        startActivity(intent)
    }

}
