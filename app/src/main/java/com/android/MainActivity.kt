package com.android

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.android.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            edit.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(s: CharSequence?,start: Int,count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {        //[oO] - o & O

                       val words = edit.text.toString().trim()
                       val count = words.split("\\b[a-np-zA-NP-Z]*[oO][a-np-zA-NP-Z]*\\b".toRegex()).size - 1
                       txt.text = "$count"

                }
            })
        }
    }

}