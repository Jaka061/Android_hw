package com.android

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.android.databinding.FragmentBinding

//Reg
class Fragment2 : Fragment(R.layout.fragment_about) {

    private lateinit var listener : OnClick
    private lateinit var binding: FragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
        binding = FragmentBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = arguments?.getString("textF")
    }

}