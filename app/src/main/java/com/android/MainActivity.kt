package com.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var countMax = 0
        var numA: Int
        var wrdMax = ""


        binding.apply {
              btn.setOnClickListener {
                  val listA = edit.text.toString().trim().split("\\s+".toRegex())

                  listA.forEach {
                      if(it.contains("a")){
                          numA = it.count { wrd -> wrd == 'a' }
                          if(countMax < numA){
                              countMax = numA
                              wrdMax = it
                          }
                      }
                  }
                  txt.text = wrdMax + "- $countMax"
              }
        }

    }
}

// работает , но если стереть некоторые записи результат не меняется .
// Учитывает  только новые записи не смогла этот момент доработать (