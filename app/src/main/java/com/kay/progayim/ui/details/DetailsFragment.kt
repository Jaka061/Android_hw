package com.kay.progayim.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kay.progayim.databinding.FragmInfoBinding
import com.kay.progayim.ui.Event

class DetailsFragment: Fragment() {

    private var _binding: FragmInfoBinding? = null
    private val binding: FragmInfoBinding
    get() = _binding!!
    private lateinit var detailVM: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailVM = ViewModelProvider(this)[DetailsViewModel::class.java]
        detailVM.setId(arguments?.getLong(Long::class.java.canonicalName))
        detailVM.fetchCh()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmInfoBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        detailVM.event.observe(viewLifecycleOwner,{
            when(it){
                is Event.FetchedCh -> {
                    setInfoCh(it)
                }
                else -> {}
            }
        })
    }

    private fun setInfoCh(it: Event.FetchedCh) {
        binding.login.text = it.character.name
        binding.email.text = it.character.status
        binding.password.text = it.character.species
    }

    companion object{
        fun newInstance(id: Long): DetailsFragment {
            val argum = Bundle().apply { putLong(Long::class.java.canonicalName, id) }
            return DetailsFragment().apply { arguments = argum }
        }
    }

}