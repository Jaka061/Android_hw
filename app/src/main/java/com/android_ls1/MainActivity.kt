package com.android_ls1

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    private lateinit var  txt1 : AppCompatTextView
    private lateinit var btn1 : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt1 = findViewById<AppCompatTextView>(R.id.txt)
        btn1 = findViewById<AppCompatButton>(R.id.plus)

        btn1.setOnClickListener {
        }
    }

}
