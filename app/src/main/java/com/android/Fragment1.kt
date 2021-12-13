package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment) {

    private lateinit var txt : AppCompatTextView
    private lateinit var btn :  AppCompatImageButton
    private lateinit var btn2 : AppCompatImageButton
    private lateinit var btn3 : AppCompatImageButton

    private lateinit var listener : onBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as onBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.fragTxt)
        btn = view.findViewById(R.id.btn1)
        btn2 = view.findViewById(R.id.btn2)
        btn3 = view.findViewById(R.id.btn3)


        btn.setOnClickListener {
            listener.setImage(R.mipmap.ic_launcher)
        }
        btn2.setOnClickListener {
            listener.setImage(R.mipmap.ic_launcher_circle)
        }
        btn3.setOnClickListener {
            listener?.setImage(R.mipmap.ic_launcher_circle_round)
        }
    }


}