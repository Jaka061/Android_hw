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
                  var num = edit.text?.replace("\\s+".toRegex(), "")
                  val lng = edit.text?.length.toString()

                  val map = mutableMapOf("0" to "ноль","1" to "один","2" to "два", "3" to "три")
                  map["4"] = "четыре"
                  map["5"] = "пять"
                  map["6"] = "шесть"
                  map["7"] = "семь"
                  map["8"] = "восемь"
                  map["9"] = "девять"

                  var numTxt = ""
                  if (num != null) {
                      for (i in num){
                          numTxt += " " + map[i.toString()]
                      }
                  }
                  txt.text = numTxt
              }
        }
    }
}
