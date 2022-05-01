package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.repo.OnlineCoursesRepo
import com.kay.progayim.data.models.Courses
import com.kay.progayim.extensions.toCharacters
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterUseCase(
    private val onlineCoursesRepo: OnlineCoursesRepo
) {
    operator fun invoke(): Observable<Unit> {
        return onlineCoursesRepo.getAll()
            .map {
                Thread.sleep(2000)
                it
            }
            .map {
                val list = mutableListOf<Courses>()
                it.results.forEach {
                    list.add(it.toCharacters())
                }
                list.toList()
            }
            .map {
                onlineCoursesRepo.insertAll(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}