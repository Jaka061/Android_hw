package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kay.progayim.databinding.FragmEditBinding

class FragmentEdit : Fragment(R.layout.fragm_edit) {
    private var binding1 : FragmEditBinding? = null
    private val binding get() = binding1!!
    private val dbInstance get() = Injector.database
    private lateinit var listener : OnBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmEditBinding.bind(view)

        binding.apply {
            btn.setOnClickListener {
                val id = arguments?.getLong("id")!!
                val e = dbInstance.userDao().getById(id)
                if (name.text.toString().isNotEmpty() && lastname.text.toString().isNotEmpty() && passwd.text.toString().isNotEmpty()) {
                    e.name = name.text.toString()
                    e.email = lastname.text.toString()
                    e.passwd = passwd.toString()

                    dbInstance.userDao().update(e)
                    requireActivity().onBackPressed()
                }
                else{
                    Toast.makeText(context, "Заполните все поля !", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}