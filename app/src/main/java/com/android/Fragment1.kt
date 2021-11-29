package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment(R.layout.fragment) {

    private lateinit var txt : AppCompatTextView
    private lateinit var btn : AppCompatButton
    private lateinit var edit: AppCompatEditText

    private lateinit var listener : onBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as onBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.fragTxt)
        btn = view.findViewById(R.id.btn1)
        edit = view.findViewById(R.id.edit)


        btn.setOnClickListener {
            val text = edit.text
            listener.setText1(text.toString())
        }

    }
    fun setText(entText :String){
        txt.text = entText
    }

}