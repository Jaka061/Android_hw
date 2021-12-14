package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

// hw-18: Нету стрелки назад в тулбаре
// hw-18: Названия классам следует давать осмысленные -> AboutFragment, MainFragmetn, AuthFragment и тд. На классных уроках так называли для примера

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
