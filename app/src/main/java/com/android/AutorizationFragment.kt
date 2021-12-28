package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.android.databinding.FragmentBinding

class AutorizationFragment : Fragment(R.layout.fragment) {

    private lateinit var listener : OnClick
    private var binding1 : FragmentBinding? = null
    private val binding get() = binding1!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1 = FragmentBinding.bind(view)

        val email = "qwerty@gmail.com"
        val pss = "1234"

        binding.apply {
            editE.doOnTextChanged { text, _, _, _ ->
                if (text!!.length > 20) {
                    editE.error = "More than 20 characters!"
                } else if (text.length < 10) {
                    editE.error = null
                }
            }
            btn.setOnClickListener {
                if (editE.text.toString().isNotEmpty() && editP.text.toString().isNotEmpty()) {
                    if (binding.editE.text.toString() == email && editP.text.toString() == pss) {
                        listener.onClickFragGl()
                    }else{
                        editEmail.error = "Wrong login or password!"
                        editPass.error = "Wrong login or password!"
                    }
                } else if (editE.text.toString().isEmpty() && editP.text.toString().isNotEmpty()) {
                    editEmail.error = "Email must not be empty !"
                    editPass.error = null
                } else if (editE.text.toString().isNotEmpty() && editP.text.toString().isEmpty()){
                    editEmail.error = null
                    editPass.error = " Password must not be empty !"
                }
                else{
                    editEmail.error = "* * *"
                    editPass.error = "* * *"
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }

}