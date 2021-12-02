package com.android

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.databinding.Fragment2Binding
import com.android.databinding.FragmentBinding

class Fragment1 : Fragment(R.layout.fragment) {

    private lateinit var binding : FragmentBinding
    private lateinit var listener : onBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentBinding.inflate(layoutInflater)
        listener = context as onBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(activity)
        val adapter = SimpleAdapter {
            val text = "Item-$it"
            listener.setText1(text)
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")
        }
        adapter.setData(list)

    }
}