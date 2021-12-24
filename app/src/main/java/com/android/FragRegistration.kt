package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class FragRegistration : Fragment(R.layout.fragment2) {

    private lateinit var listener : OnClick
    private val pref get() = Injector.preferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editL = view.findViewById<AppCompatEditText>(R.id.editLog)
        val editP = view.findViewById<AppCompatEditText>(R.id.editPass)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)


        btn.setOnClickListener {
            if(editL.text.toString().isNotEmpty() && editP.text.toString().isNotEmpty()) {
                pref.saveLogin("login", editL.text.toString())
                pref.savePassword("password", editP.text.toString())
                Toast.makeText(context, "Готово !", Toast.LENGTH_SHORT).show()
                listener.goToAutorization()
            }
            else{
                Toast.makeText(context, "Заполните поля !", Toast.LENGTH_SHORT).show()
            }
        }
    }

}