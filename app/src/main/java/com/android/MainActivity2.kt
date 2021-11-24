package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txt = findViewById<TextView>(R.id.txt2)
        val textItem = intent.getStringExtra("text")
        txt.text = textItem
    }
}