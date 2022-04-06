package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kay.progayim.database.User
import com.kay.progayim.databinding.FragmAddBinding

class FragmentAdd : Fragment(R.layout.fragm_add) {
    private var binding1 : FragmAddBinding? = null
    private val binding get() = binding1!!
    private lateinit var listener : OnBtnClicked
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmAddBinding.bind(view)

        binding.apply {
            btn.setOnClickListener {

                if (name.text.toString().isNotEmpty() && lastname.text.toString().isNotEmpty() && age.text.toString().isNotEmpty() && gender.text.toString().isNotEmpty() && passwd.text.toString().isNotEmpty()) {
                    val e = User(
                        name = name.text.toString(),
                        lastname = lastname.text.toString(),
                        age = age.text.toString().toInt(),
                        gender = gender.text.toString(),
                        passwd = passwd.text.toString()
                    )
                    dbInstance.userDao().insert(e)
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