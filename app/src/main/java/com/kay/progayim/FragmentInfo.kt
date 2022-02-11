package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kay.progayim.databinding.FragmInfoBinding

class FragmentInfo : Fragment(R.layout.fragm_info) {
    private var binding1 : FragmInfoBinding? = null
    private val binding get() = binding1!!

    private lateinit var listener : OnBtnClicked
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmInfoBinding.bind(view)

        binding.apply {
            val e = dbInstance.employeeDao().getLast()
            dbName.text = e.name
            dbComp.text = e.company
            dbSalary.text = e.salary.toString()

            btn.setOnClickListener {
                listener.goBack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}