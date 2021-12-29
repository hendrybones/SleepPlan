package com.example.sleepplan.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao {

    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    @Query("SELECT * from daily_sleep_quality WHERE nightId = :key")
    fun get(key: Long) :SleepNight

    @Query("DELETE FROM daily_sleep_quality")
    fun clear()

    @Query("SELECT * FROM daily_sleep_quality ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    @Query("SELECT * FROM daily_sleep_quality ORDER BY nightId DESC LIMIT 1 ")
    fun getTonight(): SleepNight?
}