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
                  val words = edit.text.toString().trim()
                  val count3 = words.split("\\b[A-Za-z][A-Za-z][A-Za-z]\\b".toRegex()).size - 1
                  val countKotlin = words.split("\\wKotlin\\w".toRegex()).size - 1    // я не поняла должно быть "kotlin" или например "gkotlina"
                  txt.text = "$count3"                                                  // , если "kotlin" то //w можно убрать
                  txtKotlin.text = "$countKotlin"

              }
        }

    }
}
