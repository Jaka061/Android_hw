package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView //remove import
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2){

    private lateinit var txt2 :  AppCompatTextView
    private lateinit var edit2 : AppCompatEditText
    private lateinit var btn2 :  AppCompatButton

    private lateinit var listener : onBtnClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as onBtnClicked
    } // add line
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// remove line

        txt2 = view.findViewById(R.id.frag2Txt)
        edit2 = view.findViewById(R.id.edit2)
        btn2 = view.findViewById(R.id.btn2)

        btn2.setOnClickListener {
            val text = edit2.text
            listener.setText2(text.toString())
        }
    } // add line
    fun setText2(entText :String){
        txt2.text = entText
    }
}