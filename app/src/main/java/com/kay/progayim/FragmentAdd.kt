package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kay.progayim.database.Employee
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
                if (empName.text.toString().isNotEmpty() && empComp.text.toString().isNotEmpty() && empSalary.text.toString().isNotEmpty()  ) {
                    val e = Employee(
                        name = empName.text.toString(),
                        company = empComp.text.toString(),
                        salary = empSalary.text.toString().toInt()
                    )
                    dbInstance.employeeDao().insert(e)
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