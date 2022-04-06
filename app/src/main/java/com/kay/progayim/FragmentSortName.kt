package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.databinding.FragmSortnameBinding

class FragmentSortName : Fragment(R.layout.fragm_sortname) {
    private var binding1: FragmSortnameBinding? = null
    private val binding get() = binding1!!

    private lateinit var listener: OnBtnClicked
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1 = FragmSortnameBinding.bind(view)
        val id = arguments?.getLong("id")!!
        val user = dbInstance.userDao().getById(id)

        val layoutManager = LinearLayoutManager(activity)
        val adapter = EmpAdapter(
            click = {
                val emp = dbInstance.userDao().getById(it)
                if (emp == user) {
                    listener.goToInfo(it)
                }
                else {
                    Toast.makeText(context, "У вас нет доступа !", Toast.LENGTH_SHORT).show()
                }
            },
            del = {
                val emp = dbInstance.userDao().getById(it)
                if (emp == user) {
                    dbInstance.userDao().delete(emp)
                }
                else Toast.makeText(context, "У вас нет доступа !", Toast.LENGTH_SHORT).show()
            },
            upd = {
                val emp = dbInstance.userDao().getById(it)
                if (emp == user) {
                    listener.goTOEdit(it)
                }
                else Toast.makeText(context, "У вас нет доступа !", Toast.LENGTH_SHORT).show()
            }
        )

        binding.apply {
            recycler.layoutManager = layoutManager
            recycler.adapter = adapter
            recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

            val empList = dbInstance.userDao().getAll()
            btn.setOnClickListener {
                val user = empList.filter {
                    it.name == name.text.toString()
                }
                adapter.setData(user)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}