package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val edit = findViewById<AppCompatEditText>(R.id.editText)
        val btn1 = findViewById<AppCompatButton>(R.id.btn1)

        btn1.setOnClickListener {
            val intent= Intent()
            intent.putExtra("Text", edit.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}