package com.android

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

//Reg
class Fragment2 : Fragment(R.layout.fragment2) {

    private lateinit var listener : OnClick
    //private val pref get() = Injector.preferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = requireContext().getSharedPreferences("Logins", MODE_PRIVATE)

        val editL = view.findViewById<AppCompatEditText>(R.id.editLog)
        val editP = view.findViewById<AppCompatEditText>(R.id.editPass)
        val btn = view.findViewById<AppCompatButton>(R.id.btn)


        btn.setOnClickListener {
            val editor = pref.edit()
            if(editL.text.toString().isNotEmpty() && editP.text.toString().isNotEmpty()) {
                editor.putString("login", editL.text.toString())
                editor.putString("password", editP.text.toString())
                editor.apply()

                Toast.makeText(context, "Готово !", Toast.LENGTH_SHORT).show()
                listener.onClickFrag1()
            }
            else{
                Toast.makeText(context, "Заполните поля !", Toast.LENGTH_SHORT).show()
            }
        }
    }

}