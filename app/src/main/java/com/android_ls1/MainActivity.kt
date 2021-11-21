package com.android_ls1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var btn1 : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById<AppCompatButton>(R.id.one )


        btn1.setOnClickListener {
        }

    }
fun appExpresstion(string : String ,canClear : Boolean){
    if(canClear){
        tvResult.text = ""
        tvExpesstion.append(string)
    }else{
        tvExpression.append(tvResult.text)
        tvExpesstion.append(string)
        tvResult.text = ""

    }
}

}
