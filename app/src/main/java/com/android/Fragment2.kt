package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2){

    private lateinit var txt2 :  AppCompatTextView

    private lateinit var listener : onBtnClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as onBtnClicked
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt2 = view.findViewById(R.id.txt2)

    }
    fun setText2(entText :String){
        txt2.text = entText
    }
}