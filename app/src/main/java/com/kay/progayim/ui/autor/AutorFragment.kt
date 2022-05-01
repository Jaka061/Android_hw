package com.kay.progayim.ui.autor

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kay.progayim.Injector
import com.kay.progayim.R
import com.kay.progayim.databinding.FragmAutorBinding
import com.kay.progayim.ui.OnClick

class AutorFragment : Fragment(R.layout.fragm_autor) {
    private var binding1 : FragmAutorBinding? = null
    private val binding get() = binding1!!
    private lateinit var listener : OnClick
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1 = FragmAutorBinding.bind(view)


        binding.apply {
            name.addTextChangedListener(textWatcher)
            passwd.addTextChangedListener(textWatcher)

            val num = dbInstance.userDao().getAll()

            val user = dbInstance.userDao().getAll()
            btn.setOnClickListener {
                val user = num.find {
                    it.login == name.text.toString()  && it.password == passwd.text.toString()
                }

                if(user != null) listener.goMain(user.id!!)
                else Toast.makeText(context, "Такого пользователя нет!", Toast.LENGTH_SHORT).show()

            }
            btn2.setOnClickListener {
                listener.goToAdd()
            }
        }

    }
    private val textWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.apply {
                val login = name.text.toString().trim()
                val passwd = passwd.text.toString().trim()
                btn.isEnabled = login.isNotEmpty() && passwd.isNotEmpty()
            }
        }
        override fun afterTextChanged(s: Editable?) {}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}