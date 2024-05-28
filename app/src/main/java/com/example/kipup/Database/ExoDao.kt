package com.example.kipup.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ExoDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exo: Exo)
    @Update
    suspend fun update(exo: Exo)

    @Delete
    suspend fun delete(exo: Exo)

    @Query("SELECT * from exos WHERE exoId = :exoId")
    fun getExo(exoId: Int): Flow<Exo>

    @Query("SELECT * from exos ORDER BY nom ASC")
    fun getAllExos(): Flow<List<Exo>>
}