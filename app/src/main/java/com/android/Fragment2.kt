package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2){

    private lateinit var listener : OnBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt = view.findViewById<AppCompatTextView>(R.id.txt2)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)

        val textFr = arguments?.getString("textF")
        txt.text = textFr

        btn.setOnClickListener {
            listener.onClick(textFr.toString())

        }


    }

}