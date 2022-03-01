package com.kay.progayim

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.kay.progayim.databinding.FragmInfoBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentInfo : Fragment(R.layout.fragm_info) {
    private var binding1 : FragmInfoBinding? = null
    private val binding get() = binding1!!

    private lateinit var listener : OnBtnClicked
    private val episodee get() = Injector.breakingBadApi

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmInfoBinding.bind(view)
        val id = arguments?.getLong("id")!!
        binding.apply {
            Log.e("TAG", "ID")
                episodee.getEpisode(id)
                    .subscribeOn(Schedulers.io())
                    .map { it.first() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess {
                        Title.text = "Title: " + it.title
                        season.text = "season: " + it.season.toString()
                        airDate.text = "air date: " + it.air_date
                        episode.text = "episode: " + it.episode
                        series.text = "series: " + it.series

                        Log.e(
                            "TAG",
                            "fragmentItemInfo doOnSuccess getById ${Thread.currentThread().name}"
                        )
                    }
                    .doOnError {
                        Log.e(
                            "TAG",
                            "fragmentItemInfo doOnError getById ${Thread.currentThread().name}"
                        )
                    }
                    .subscribe()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}