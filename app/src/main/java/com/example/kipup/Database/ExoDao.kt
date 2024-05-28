package com.example.kipup.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface ExoDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exo: Exo)
    @Update
    suspend fun update(exo: Exo)

    @Delete
    suspend fun delete(exo: Exo)
}