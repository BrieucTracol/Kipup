package com.example.kipup.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update


@Dao
interface SeanceDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(seance: Seance)
    @Update
    suspend fun update(seance: Seance)

    @Delete
    suspend fun delete(seance: Seance)
}
