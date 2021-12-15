package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class AboutMe : Fragment(R.layout.fragment_about) {

    private lateinit var listener : OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar =  view.findViewById<Toolbar>(R.id.toolbarMenu)
        toolbar.setNavigationOnClickListener{
            requireActivity().onBackPressed()
        }

    }

}