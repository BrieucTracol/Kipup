package com.example.kipup.Database

import android.content.Context
interface AppContainer {
    val exoRepository: ExoRepository
}
/**
 * [AppContainer] implementation that provides instance of [offlineExoRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ExoRepository]
     */
    override val exoRepository: ExoRepository by lazy {
        offlineExoRepository(MyDataBase.getDatabase(context).exoDao())
    }
}