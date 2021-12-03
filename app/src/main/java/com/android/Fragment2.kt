package com.android

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.android.databinding.Fragment2Binding
import com.android.databinding.FragmentBinding

class Fragment2 : Fragment(R.layout.fragment2){

    private lateinit var binding : Fragment2Binding
    private lateinit var listener : OnBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked


    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Fragment2Binding.inflate(layoutInflater)
        val textFr = arguments?.getString("textF")
        binding.txt2.text = textFr

        binding.btn.setOnClickListener {
            listener.onClick()
        }


    }

}