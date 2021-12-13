package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment_about) {

    private lateinit var listener : OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}