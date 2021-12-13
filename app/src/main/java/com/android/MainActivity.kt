package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.android.databinding.ActivityMainBinding
import com.android.databinding.FragmentBinding

class MainActivity : AppCompatActivity(),OnClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()

        val toolbar =  findViewById<Toolbar>(R.id.toolbarGlav)
        setSupportActionBar(toolbar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onClickFragAuto() {
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment1)
            .addToBackStack(null).commit()
    }

    override fun onClickFragMenu() {
        val fragment2 = Fragment2()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }

    override fun onClickFragGl() { //glavn
        val fragment3 = Fragment3()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment3).commit()
    }
}
