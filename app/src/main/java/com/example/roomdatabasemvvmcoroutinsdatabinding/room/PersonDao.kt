package com.example.roomdatabasemvvmcoroutinsdatabinding.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(personModel: PersonModel);

    @Delete
    suspend fun delete(personModel: PersonModel)

    @Update
    suspend fun update(personModel: PersonModel)

    @Query("SELECT * FROM PersonModel")
    suspend fun getAllPerson():List<PersonModel>

}