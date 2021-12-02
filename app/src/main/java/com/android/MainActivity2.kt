package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.databinding.ActivityMain2Binding
import com.android.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        //binding.txt2
        //val txt = findViewById<TextView>(R.id.txt2)
        val textItem = intent.getStringExtra("text")
        binding.txt2.text = textItem
    }
}