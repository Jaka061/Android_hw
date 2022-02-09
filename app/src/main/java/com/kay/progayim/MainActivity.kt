package com.kay.progayim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kay.progayim.database.Employee
import com.kay.progayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnBtnClicked {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragm_cont, FragmentEdit())
            .commit()
    }

    override fun onClick() {
        val fragment = FragmentDB()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragm_cont,fragment)
            .addToBackStack(null).commit()
    }
}