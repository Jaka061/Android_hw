package com.kay.progayim.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kay.progayim.App
import com.kay.progayim.data.repo.OnlineCoursesRepo
import com.kay.progayim.domain.use_cases.GetCharacterByIdUseCase
import com.kay.progayim.ui.Event
import io.reactivex.disposables.CompositeDisposable

class DetailsViewModel(application: Application) : AndroidViewModel(application)  {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private  var id: Long = -1 //?
    fun setId(id: Long?){
        this.id = id ?: -1
    }

    private val event1 = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = event1


    private val rickAndMortyRepo = OnlineCoursesRepo(
        getApplication<App>().rickAndMortyApi,
        getApplication<App>().database.courseDao(),
        getApplication<App>().database.userDao()
    )

    private val getCharacterByIdUseCase: GetCharacterByIdUseCase =
        GetCharacterByIdUseCase(rickAndMortyRepo)

    fun fetchCh(){
        compositeDisposable.add(
            getCharacterByIdUseCase(id)
                .subscribe({
                           event1.value = Event.FetchedCh(it)
                },{

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}