package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.models.Characters
import com.kay.progayim.data.repo.RickAndMortyRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterByIdUseCase(private val repo: RickAndMortyRepo) {

    operator fun invoke(id: Long): Single<Characters> {
        return repo.getById(id)
            .map {
                Thread.sleep(1000)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}