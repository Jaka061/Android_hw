package com.android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
//avt
class Fragment1 : Fragment(R.layout.fragment) {

    private lateinit var  editLog : AppCompatEditText
    private lateinit var editPass: AppCompatEditText
    private lateinit var btn : AppCompatButton
    private lateinit var btn2: AppCompatButton

    private lateinit var listener : OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = requireContext().getSharedPreferences("Logins", Context.MODE_PRIVATE)

        editLog = view.findViewById(R.id.editLog)
        editPass = view.findViewById(R.id.editPass)
        btn = view.findViewById(R.id.btn)
        btn2 = view.findViewById(R.id.btn2)

        val log = pref.getString("login","avto")
        val pss = pref.getString("password","1234")

        btn.setOnClickListener {
            if(editLog.text.toString().isNotEmpty() && editPass.text.toString().isNotEmpty()) {
                if (editLog.text.toString() == log && editPass.text.toString() == pss) {
                    listener.onClickFrag3(log)      // glavn.
                } else if (editLog.text.toString() != log || editPass.text.toString() != log) {
                    Toast.makeText(context, "Такого пользователя нет !", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(requireContext(), "Заполните поля !", Toast.LENGTH_LONG).show()
            }
        }

        btn2.setOnClickListener {
            listener.onClickFrag2()     // reg
        }
    }
}