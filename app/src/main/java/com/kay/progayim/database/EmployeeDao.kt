package com.kay.progayim.database

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee")
    fun getAll():Observable<List<Employee>>

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id: Long): Single<Employee>

//    @Query("SELECT * FROM employee ORDER BY id DESC LIMIT 1")
//    fun getLast(): Employee

    @Insert
    fun insert(employee: Employee) :Completable

    @Update
    fun update(employee: Employee):Completable

    @Delete
    fun delete(employee: Employee) : Completable
}