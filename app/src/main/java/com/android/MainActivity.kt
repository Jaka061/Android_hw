package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton

class MainActivity : AppCompatActivity(), onBtnClicked {


    private var text2 : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag1,Fragment1()).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frag2,Fragment2()).commit()


    }
    override fun setImage(image : Int) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.frag2) as? Fragment2
        fragment2?.setImage(image)

    }

}
