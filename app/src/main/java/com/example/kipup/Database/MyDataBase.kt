package com.example.kipup.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

@Database(entities = [Exo::class], version = 1, exportSchema = false)
abstract class MyDataBase : RoomDatabase() {
    abstract fun itemDao(): ExoDao
    //abstract fun seanceDao(): SeanceDao
    //abstract fun serieDao(): SerieDao

    companion object{
        @Volatile
        private var Instance: MyDataBase? = null
        fun getDatabase(context: Context): MyDataBase{
            return Instance ?:synchronized(this) {
                Room.databaseBuilder(context, MyDataBase::class.java, "sport_database")
                    .build()
                    .also{Instance = it}
            }
        }
    }
}