package com.kay.progayim.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kay.progayim.data.models.Characters
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CharacterDao {

    @Query("SELECT * FROM Characters")
    fun getAll(): LiveData<List<Characters>>

    @Query("SELECT * FROM Characters WHERE id = :id")
    fun getById(id: Long?): Single<Characters>

    @Insert
    fun insert(character: Characters): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(characters: List<Characters>)

    @Update
    fun update(character: Characters)

    @Delete
    fun delete(character: Characters)

    @Query("DELETE from Characters")
    fun deleteAll(): Completable
}