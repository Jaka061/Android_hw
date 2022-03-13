package com.example.android

import android.content.Context
import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var svetofor : ConstraintLayout
    private lateinit var txt : AppCompatTextView
    private lateinit var time : AppCompatTextView
    private lateinit var img : AppCompatImageView
    var counter = 0

    val urlRed = "https://w7.pngwing.com/pngs/150/578/png-transparent-traffic-light-computer-icons-red-red-light-color-light-traffic-thumbnail.png"
    val urlYellow = "https://w7.pngwing.com/pngs/136/898/png-transparent-traffic-light-computer-icons-yellow-traffic-light-color-light-nuvola-thumbnail.png"
    val urlGreen = "https://w7.pngwing.com/pngs/104/123/png-transparent-round-black-and-green-button-green-light-green-light-traffic-light-light-circle-color-desktop-wallpaper-light-thumbnail.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        txt = findViewById(R.id.txt)
        time = findViewById(R.id.time)
        svetofor = findViewById(R.id.svetofor)

        startTimeCounter()
    }

    private fun startTimeCounter() {
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                time.text = counter.toString()
                counter++
                if(millisUntilFinished / 1000 == 9L ){
                    txt.text = "Stop"
                    Glide.with(this@MainActivity).load(urlRed).override(600,700).into(img)
                    svetofor.setBackgroundColor(parseColor("red"))
                }
                else if(millisUntilFinished / 1000 ==  5L){
                    txt.text = "Wait"
                    Glide.with(this@MainActivity).load(urlYellow).override(600,700).into(img)
                    svetofor.setBackgroundColor(parseColor("yellow"))
                }
                else if(millisUntilFinished / 1000 ==  2L){
                    txt.text = "Go"
                    Glide.with(this@MainActivity).load(urlGreen).override(600,700).into(img)
                    svetofor.setBackgroundColor(parseColor("green"))
                }
            }
            override fun onFinish() {
                txt.text = "Finish"
            }
        }.start()
    }



}