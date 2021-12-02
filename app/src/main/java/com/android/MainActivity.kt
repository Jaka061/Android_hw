package com.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), onBtnClicked {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()

    }
    override fun setText1(enterText: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("textF",enterText)
        fragment2.arguments = bundle


        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()

    }
    override fun onClick(){
        val intent = Intent(this,MainActivity2::class.java)
        intent.putExtra("text", "Main Activity2 ")
        startActivity(intent)
    }

}
