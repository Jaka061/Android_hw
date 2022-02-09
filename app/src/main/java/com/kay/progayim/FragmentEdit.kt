package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kay.progayim.database.Employee
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
                val e = Employee(
                    name = empName.text.toString(),
                    company = empComp.text.toString(),
                    salary = empSalary.text.toString().toInt()
                )
                dbInstance.employeeDao().insert(e)
                listener.onClick()
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}