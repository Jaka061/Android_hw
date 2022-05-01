package com.kay.progayim.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.databinding.FragmMainBinding
import com.kay.progayim.ui.details.DetailsFragment
import com.kay.progayim.ui.OnClick
import com.kay.progayim.ui.main.rv.CharacterAdapter

class MainFragment: Fragment(), CharacterAdapter.Listener {

    private var _binding: FragmMainBinding? = null
    private val binding: FragmMainBinding
    get() = _binding!!
    private lateinit var listener: OnClick
    private lateinit var mainVM : MainViewModel
    private val chAdapter: CharacterAdapter = CharacterAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainVM = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmMainBinding.inflate(inflater)
        return binding.root
        Log.e("id","kkk")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        subscribeToLD()
        Log.e("id","lll")
    }

    private fun setupViews() {
        with(binding){
            recycler.adapter = chAdapter
            val layoutManager = LinearLayoutManager(activity)
            recycler.layoutManager = layoutManager
            recycler.adapter = chAdapter
            recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
        }
    }

    private fun subscribeToLD(){
        mainVM.coursesLiveData.observe(viewLifecycleOwner, {
            chAdapter.setData(it)
            Log.e("id","llgggl")
        })

//        mainVM.event.observe(viewLifecycleOwner, {
//            when(it){
//                is Event.ShowToast -> showToast(getString(it.resId))
//                is Event.ShowLoading -> binding.swipeRefreshLayout.isRefreshing = true
//                is Event.StopLoading -> binding.swipeRefreshLayout.isRefreshing = false
//                else -> {}
//            }
//        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainVM.clearEvents()
        _binding = null
    }

    override fun click(index: Int) {
        mainVM.getCharacterByIndex(index)?.let {
            listener.openFragm(DetailsFragment.newInstance(it.id))
            Log.e("id","$it.id")
        }
    }
}