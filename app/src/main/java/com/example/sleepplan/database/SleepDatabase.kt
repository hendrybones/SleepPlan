package com.example.sleepplan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities=[SleepNight:: class], version=1, exportSchema = false)
abstract class SleepDatabase: RoomDatabase() {
    abstract  val sleepDatabaseDao: SleepDatabaseDao

    companion object{
        // this makes sure the value is always upto date
        @Volatile
        private var INSTANCE: SleepDatabase?=null

        //return the reference to the sleep database
        @InternalCoroutinesApi
        fun getInstance(context: Context): SleepDatabase{
            synchronized(this){
                var instance=INSTANCE

                if (instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance

            }
        }

    }
}