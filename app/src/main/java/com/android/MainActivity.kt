package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),OnClick {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val menu = findViewById<NavigationView>(R.id.menu)

        drawerLayout = findViewById(R.id.drawerLayout)
        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,AutorizationFragment()).commit()
    }

    override fun onClickFragMenu() {
        val fragment2 = AboutMeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null).commit()
    }

    override fun onClickFragGl() {
        val fragment3 = MenuFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment3).commit()
    }
}
