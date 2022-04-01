package com.kay.progayim.data.repo

import com.kay.progayim.data.models.Characters
import com.kay.progayim.data.models.ResponseDto
import com.kay.progayim.data.network.RickandmortyApi
import com.kay.progayim.data.storage.CharacterDao
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RickAndMortyRepo(
    private val rickAndMortyApi: RickandmortyApi,
    private val characterDao: CharacterDao
    ) {

    fun getAll(): Observable<ResponseDto> {
        return rickAndMortyApi.getAll()
            .subscribeOn(Schedulers.io())
    }

    fun insertAll(characterList: List<Characters>){
        characterDao.insertList(characterList)
    }

    fun deleteAll(): Completable {
        return characterDao.deleteAll()
            .subscribeOn(Schedulers.io())
    }

    fun getById(id: Long): Single<Characters> {
        return characterDao.getById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getAllAsLive() = characterDao.getAll()
}