package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Autorization : Fragment(R.layout.fragment) {

    private lateinit var listener : OnClick
    private lateinit var  editEmail : AppCompatEditText
    private lateinit var editPass: AppCompatEditText
    private lateinit var btn : AppCompatButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editEmail = view.findViewById(R.id.editEmail)
        editPass = view.findViewById(R.id.editPass)
        btn = view.findViewById(R.id.btn)

        val email = "qwerty@gmail.com"
        val pss = "1234"
        btn.setOnClickListener {
            if (editEmail.text.toString().isNotEmpty() && editPass.text.toString().isNotEmpty()) {
                if (editEmail.text.toString() == email && editPass.text.toString() == pss) {
                    listener.onClickFragGl()
                } else if (editEmail.text.toString() != email || editPass.text.toString() != email) {
                    Toast.makeText(context, "Такого пользователя нет !", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(requireContext(), "Заполните поля !", Toast.LENGTH_LONG).show()
            }
        }
    }

}