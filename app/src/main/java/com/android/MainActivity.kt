package com.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        val recycle = findViewById<RecyclerView>(R.id.recycler)
//        val layMan = LinearLayoutManager(this)
//        val adapter = SimpleAdapter{
//            Toast.makeText(this,"Item -$it",Toast.LENGTH_SHORT).show()
//        }
//
//        recycle.layoutManager = layMan
//        recycle.adapter =adapter
//        recycle.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
//
//
//        val list = mutableListOf<String>()
//        for (i in 0..20) {
//            list.add("ITEM -$i")
//        }
//        adapter.setData(list)
        }

}
