package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.repo.OnlineCoursesRepo
import io.reactivex.Completable

class DeleteCharactersUseCase(private val onlineCoursesRepo: OnlineCoursesRepo) {

    operator fun invoke(): Completable {
        return onlineCoursesRepo.deleteAll() // use case взяла полностью из вашего кода
    }

}