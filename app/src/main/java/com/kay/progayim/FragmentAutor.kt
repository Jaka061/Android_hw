package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kay.progayim.databinding.FragmAddBinding
import com.kay.progayim.databinding.FragmAutorBinding

class FragmentAutor : Fragment(R.layout.fragm_autor) {
    private var binding1 : FragmAutorBinding? = null
    private val binding get() = binding1!!
    var i : Long = 1
    private lateinit var listener : OnBtnClicked
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1 = FragmAutorBinding.bind(view)


        binding.apply {
            name.addTextChangedListener(textWatcher)
            passwd.addTextChangedListener(textWatcher)

            val num = dbInstance.userDao().getAll()

            btn.setOnClickListener {
                val user = num.find {
                    it.name == name.text.toString()  && it.passwd == passwd.text.toString()
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