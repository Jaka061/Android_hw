package com.kay.progayim.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kay.progayim.*
import com.kay.progayim.data.repo.OnlineCoursesRepo
import com.kay.progayim.data.models.Courses
import com.kay.progayim.domain.use_cases.DeleteCharactersUseCase
import com.kay.progayim.domain.use_cases.GetCharacterUseCase
import com.kay.progayim.domain.use_cases.GetCharactersAsLiveDataUseCase
import com.kay.progayim.ui.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.net.UnknownHostException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val rickAndMortyRepo = OnlineCoursesRepo(
        getApplication<App>().rickAndMortyApi,
        getApplication<App>().database.courseDao()
    )

    private val getCharacterUseCase = GetCharacterUseCase(rickAndMortyRepo)
    private val deleteCharactersUseCase = DeleteCharactersUseCase(rickAndMortyRepo)
    private val getCharactersAsLiveUseCase = GetCharactersAsLiveDataUseCase(rickAndMortyRepo)
    val coursesLiveData: LiveData<List<Courses>> = getCharactersAsLiveUseCase()

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        _event.value = Event.ShowLoading
        compositeDisposable.add(
            getCharacterUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { _event.value = Event.StopLoading }
                .subscribe({}, { handleError(it) } )
        )
    }

    private fun handleError(it: Throwable) {
        _event.value = when (it) {
            is UnknownHostException -> Event.ShowToast(R.string.no_internet)
            else -> Event.ShowToast(R.string.unknown_error)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun clearEvents() {
        _event.value = null
    }

    fun getCharacterByIndex(index: Int): Courses? {
        return coursesLiveData.value?.get(index)
    }
}