package com.example.kipup


import android.app.Application
import android.util.Log
import com.example.kipup.Database.AppContainer
import com.example.kipup.Database.AppDataContainer


class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)

    }
}