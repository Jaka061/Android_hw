package com.kay.progayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.databinding.FragmMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentMain : Fragment(R.layout.fragm_main) {
    private var binding1 : FragmMainBinding? = null
    private val binding get() = binding1!!

    private lateinit var listener : OnBtnClicked
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding1 = FragmMainBinding.bind(view)

        val layoutManager = LinearLayoutManager(activity)
        val adapter = EmpAdapter(
            click = {
                listener.goToInfo(it)
            },
            del = {
                dbInstance.employeeDao().getById(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess() {
                        dbInstance.employeeDao().delete(it)
                    }
                    .subscribe()
            }
        )
        {
            listener.goTOEdit(it)
        }

        binding.apply {
            recycler.layoutManager = layoutManager
            recycler.adapter = adapter
            recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

            btnAdd.setOnClickListener{
                listener.goToAdd()
            }
        }
        val empList = dbInstance.employeeDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                adapter.setData(it)
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}