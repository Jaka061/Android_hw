package com.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
              btn.setOnClickListener {
                  var countMax = 0
                  val listA = edit.text.toString().trim().split("\\s+".toRegex())

                  listA.forEach { it ->
                      if (it.length % 2 == 0 && it.isNotEmpty()) {
                          countMax++
                      }
                  }
                  txt.text = countMax.toString()
              }
        }

    }
}
