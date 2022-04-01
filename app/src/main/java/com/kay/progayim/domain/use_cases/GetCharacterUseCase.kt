package com.kay.progayim.domain.use_cases

import com.kay.progayim.data.repo.RickAndMortyRepo
import com.kay.progayim.data.models.Characters
import com.kay.progayim.extensions.toCharacters
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class GetCharacterUseCase(
    private val rickAndMortyRepo: RickAndMortyRepo
) {
    operator fun invoke(): Observable<Unit> {
        return rickAndMortyRepo.getAll()
            .map {
                Thread.sleep(2000)
                it
            }
            .map {
                val list = mutableListOf<Characters>()
                it.results.forEach {
                    list.add(it.toCharacters())
                }
                list.toList()
            }
            .map {
                rickAndMortyRepo.insertAll(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}