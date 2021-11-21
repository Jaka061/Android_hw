package com.android_ls1

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    private lateinit var  email1 : AppCompatEditText
    private lateinit var  title1 : AppCompatEditText
    private lateinit var  text1 : AppCompatEditText
    private lateinit var btn1 : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email1 = findViewById<AppCompatEditText>(R.id.eEmail)
        title1 = findViewById<AppCompatEditText>(R.id.eTitle)
        text1 = findViewById<AppCompatEditText>(R.id.eText)
        btn1 = findViewById<AppCompatButton>(R.id.button)


        btn1.setOnClickListener {
        }

    }

}
