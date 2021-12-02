package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.android.databinding.ActivityMainBinding
import com.android.databinding.Fragment2Binding

class Fragment2 : Fragment(R.layout.fragment2){

    private lateinit var binding : Fragment2Binding
    private lateinit var listener : onBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = Fragment2Binding.inflate(layoutInflater)
        listener = context as onBtnClicked


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt = view.findViewById<AppCompatTextView>(R.id.txt2)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)

        val textFr = arguments?.getString("textF")
        txt.text = textFr

        btn.setOnClickListener {
            listener.onClick()
        }


    }

}