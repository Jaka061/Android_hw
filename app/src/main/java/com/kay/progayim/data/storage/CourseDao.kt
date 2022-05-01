package com.kay.progayim.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kay.progayim.data.models.Courses
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CourseDao {

    @Query("SELECT * FROM Courses")
    fun getAll(): LiveData<List<Courses>>

    @Query("SELECT * FROM Courses WHERE id = :id")
    fun getById(id: Long?): Single<Courses>

    @Insert
    fun insert(character: Courses): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(characters: List<Courses>)

    @Update
    fun update(character: Courses)

    @Delete
    fun delete(character: Courses)

    @Query("DELETE from Courses")
    fun deleteAll(): Completable
}