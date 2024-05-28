package com.example.kipup.Database

import kotlinx.coroutines.flow.Flow
interface ExoRepository {

    fun getAllExosStream(): Flow<List<Exo>>

    fun getExoStream(exoId: Int): Flow<Exo?>

    suspend fun insertExo(exo: Exo)

    suspend fun deleteExo(exo: Exo)

    suspend fun updateExo(exo: Exo)
}