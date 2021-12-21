package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class MenuFragment : Fragment(R.layout.fragment_glavn) {

    private lateinit var listener : OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar =  view.findViewById<Toolbar>(R.id.toolbarGlav)
        toolbar.inflateMenu(R.menu.menu)

        toolbar.setOnMenuItemClickListener{
            when(it.itemId) {
                R.id.menu1 -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.frag_cont,AboutMeFragment())
                        .addToBackStack(null).commit()
                }
            }
            true
        }
    }
}