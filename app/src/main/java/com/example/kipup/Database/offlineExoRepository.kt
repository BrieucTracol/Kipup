package com.example.kipup.Database

import kotlinx.coroutines.flow.Flow

class offlineExoRepository(private val exoDao: ExoDao) : ExoRepository {
    override fun getAllExosStream(): Flow<List<Exo>> = exoDao.getAllExos()

    override fun getExoStream(exoId: Int): Flow<Exo?> = exoDao.getExo(exoId)

    override suspend fun insertExo(exo: Exo) = exoDao.insert(exo)

    override suspend fun deleteExo(exo: Exo) = exoDao.delete(exo)

    override suspend fun updateExo(exo: Exo) = exoDao.update(exo)

}