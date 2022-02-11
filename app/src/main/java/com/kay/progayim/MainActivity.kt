package com.kay.progayim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kay.progayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnBtnClicked {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragm_cont, FragmentMain())
            .commit()
    }

    override fun goToInfo() {
        val fragment = FragmentInfo()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragm_cont,fragment)
            .addToBackStack(null).commit()
    }

    override fun goToAdd() {
        val fragment = FragmentAdd()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragm_cont,fragment)
            .addToBackStack(null).commit()
    }

    override fun goTOEdit() {
        val fragment = FragmentEdit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragm_cont,fragment)
            .addToBackStack(null).commit()
    }

    override fun goBack() {
        val fragment = FragmentMain()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragm_cont,fragment)
            .commit()
    }
}