package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.models.Courses
import com.kay.progayim.data.repo.OnlineCoursesRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterByIdUseCase(private val repo: OnlineCoursesRepo) {

    operator fun invoke(id: Long): Single<Courses> {
        return repo.getById(id)
            .map {
                Thread.sleep(1000)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}