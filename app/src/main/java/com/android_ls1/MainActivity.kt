package com.android_ls1

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    private lateinit var  email1 : AppCompatEditText
    private lateinit var  title1 : AppCompatEditText
    private lateinit var  text1 : AppCompatEditText
    private lateinit var btn1 : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email1 = findViewById<AppCompatEditText>(R.id.eEmail)
        title1 = findViewById<AppCompatEditText>(R.id.eTitle)
        text1 = findViewById<AppCompatEditText>(R.id.eText)
        btn1 = findViewById<AppCompatButton>(R.id.button)


        btn1.setOnClickListener {
            val email2 = email1.text.toString()
            val title2 = title1.text.toString()
            val text2 = text1.text.toString()

            val mail = arrayOf(email2)
            val emailSend = Intent(Intent.ACTION_SEND)
            emailSend.putExtra(Intent.EXTRA_EMAIL, mail)
            emailSend.putExtra(Intent.EXTRA_SUBJECT,title2)
            emailSend.putExtra(Intent.EXTRA_TEXT,text2)

            emailSend.type = "message/rfc822"
            startActivity(Intent.createChooser(emailSend," Email "))
        }

    }

}
