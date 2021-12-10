package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
 //Glavn
class Fragment3 : Fragment(R.layout.fragment3) {
     private lateinit var txt :AppCompatTextView
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt = view.findViewById(R.id.txt)
        val login = arguments?.getString("textF")
        txt.text = login
    }

}