package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
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
            btnEdit.setOnClickListener {
                val id = arguments?.getLong("id")!!
                val e = dbInstance.employeeDao().getById(id)
                if (empName.text.toString().isNotEmpty() && empComp.text.toString().isNotEmpty() && empSalary.text.toString().isNotEmpty()  ) {
                    e.name = empName.text.toString()
                    e.company = empComp.text.toString()
                    e.salary = empSalary.text.toString().toInt()

                    dbInstance.employeeDao().update(e)
                    requireActivity().onBackPressed()
                }
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}