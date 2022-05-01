package com.kay.progayim.domain.use_cases

import androidx.lifecycle.LiveData
import com.kay.progayim.data.models.Courses
import com.kay.progayim.data.repo.OnlineCoursesRepo

class GetCharactersAsLiveDataUseCase(
   private val  repo: OnlineCoursesRepo
) {
    operator fun invoke(): LiveData<List<Courses>> {
        return repo.getAllAsLive()
    }
}