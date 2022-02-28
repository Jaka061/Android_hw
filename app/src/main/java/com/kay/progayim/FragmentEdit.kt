package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.kay.progayim.database.Employee
import com.kay.progayim.databinding.FragmEditBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentEdit : Fragment(R.layout.fragm_edit) {
    private var binding1 : FragmEditBinding? = null
    private val binding get() = binding1!!
    private val dbInstance get() = Injector.database
    private lateinit var listener : OnBtnClicked

    private lateinit var name : String
    private lateinit var company : String
    private lateinit var salary : String

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
                dbInstance.employeeDao().getById(id)
                if (empName.text.toString().isNotEmpty() && empComp.text.toString().isNotEmpty() && empSalary.text.toString().isNotEmpty()  ) {
                    name = empName.text.toString()
                    company = empComp.text.toString()
                    salary = empSalary.text.toString()

                    val emp = Employee(id,name,company,salary.toInt())

                    dbInstance.employeeDao().update(emp)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnComplete {
                            Log.e("TAG", "EditFragment doOnComplete ${Thread.currentThread().name}")
                            requireActivity().onBackPressed()
                        }
                        .subscribe()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}