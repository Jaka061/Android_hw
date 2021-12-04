package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.android.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textItem = intent.getStringExtra("text")
        val txt2 = findViewById<AppCompatTextView>(R.id.txt2)
        txt2.text = textItem.toString()
    }

}