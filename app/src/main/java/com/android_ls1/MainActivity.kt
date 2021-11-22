package com.android_ls1

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    private lateinit var  txt1 : AppCompatTextView
    private lateinit var btn1 : AppCompatButton
    private lateinit var btn2 : AppCompatButton
    private var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt1 = findViewById<AppCompatTextView>(R.id.txt)
        btn1 = findViewById<AppCompatButton>(R.id.button)
        btn2 = findViewById<AppCompatButton>(R.id.button1)

        btn1.setOnClickListener {
            count++
            txt1.text = count.toString()
        }
        btn2.setOnClickListener {
            if(txt1.text != "0") {
                txt1.text = "0"
            }
        }
    }

    override fun onSaveInstanceState (outState : Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt("count",count)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        txt1.text = count.toString()
    }
}
