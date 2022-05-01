package com.kay.progayim.ui.registration

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kay.progayim.Injector
import com.kay.progayim.R
import com.kay.progayim.data.models.User
import com.kay.progayim.databinding.FragmRegistBinding
import com.kay.progayim.ui.OnClick
import com.kay.progayim.ui.details.DetailsFragment

class RegistrationFragment : Fragment(R.layout.fragm_regist) {
    private var binding1 : FragmRegistBinding? = null
    private val binding get() = binding1!!
    private lateinit var listener : OnClick
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmRegistBinding.bind(view)

        binding.apply {
            btn.setOnClickListener {

                if (name.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() &&  passwd.text.toString().isNotEmpty()) {
                    val e = User(
                        id = 1L,
                        login = name.text.toString(),
                        email = email.text.toString(),
                        password = passwd.text.toString()
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