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
                  val words = edit.text.toString().trim().replace("\\s+".toRegex(), "_")
                  val punct = "[^[:word:]]".toRegex()
                  val countP = punct.replace(words,"*")
                  val fin = countP.replace("_"," ")


                  txt.text = countP.count { "*".contains(it) }.toString()
                  txtKotlin.text = fin
              }
        }

    }
}
