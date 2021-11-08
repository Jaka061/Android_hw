package com.android_ls1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_sec.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("Tag","Ex:create")  // LogCat Error ( выводит ошибки )
    }

    override fun onStart() {
        super.onStart()
        Log.e("  Tag","Ex:start")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Tag","Ex:resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Tag","Ex:pause")
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
