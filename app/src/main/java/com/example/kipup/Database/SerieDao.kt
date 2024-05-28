package com.example.kipup.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface SerieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(serie: Serie)
    @Update
    suspend fun update(serie: Serie)

    @Delete
    suspend fun delete(serie: Serie)
}
