package com.android

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2){

    private lateinit var txt : AppCompatTextView
    private lateinit var image1 : AppCompatImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.frag2txt)
        image1 = view.findViewById(R.id.img1)
    }
    fun setText(entText :String){
        txt.text = entText
    }

}