package com.kay.progayim.data.repo

import com.kay.progayim.data.models.Courses
import com.kay.progayim.data.models.ResponseDto
import com.kay.progayim.data.network.OnlineCoursesApi
import com.kay.progayim.data.storage.CourseDao
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class OnlineCoursesRepo(
    private val rickAndMortyApi: OnlineCoursesApi,
    private val courseDao: CourseDao
    ) {

    fun getAll(): Observable<ResponseDto> {
        return rickAndMortyApi.getAll()
            .subscribeOn(Schedulers.io())
    }

    fun insertAll(characterList: List<Courses>){
        courseDao.insertList(characterList)
    }

    fun deleteAll(): Completable {
        return courseDao.deleteAll()
            .subscribeOn(Schedulers.io())
    }

    fun getById(id: Long): Single<Courses> {
        return courseDao.getById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getAllAsLive() = courseDao.getAll()
}