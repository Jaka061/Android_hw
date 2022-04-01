package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.repo.RickAndMortyRepo
import io.reactivex.Completable

class DeleteCharactersUseCase(private val rickAndMortyRepo: RickAndMortyRepo) {

    operator fun invoke(): Completable {
        return rickAndMortyRepo.deleteAll() // use case взяла полностью из вашего кода
    }

}