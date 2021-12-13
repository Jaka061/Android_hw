package com.android

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.internal.view.SupportMenu
import androidx.fragment.app.Fragment
import com.android.databinding.FragmentBinding

class Fragment3 : Fragment(R.layout.fragment_glavn) {

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
                        .replace(R.id.frag_cont, Fragment2())
                        .addToBackStack(null).commit()
                }
            }
            true
        }
    }
}