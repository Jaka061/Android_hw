package com.android

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.databinding.Fragment2Binding

class FragRegistration : Fragment(R.layout.fragment2) {
    private var binding1 : Fragment2Binding? = null
    private val binding get() = binding1!!
    private lateinit var listener : OnClick
    private val pref get() = Injector.preferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1 = Fragment2Binding.bind(view)

        binding.apply {
            editLog.addTextChangedListener(textWatcher)
            editPass.addTextChangedListener(textWatcher)

            btn.setOnClickListener {
                pref.saveLogin("login", editLog.text.toString())
                pref.savePassword("password", editPass.text.toString())
                Toast.makeText(context, "Готово !", Toast.LENGTH_SHORT).show()
                listener.goToAutorization()
            }
        }
    }

    private val textWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.apply {
                val login = editLog.text.toString().trim()
                val passwd = editPass.text.toString().trim()
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