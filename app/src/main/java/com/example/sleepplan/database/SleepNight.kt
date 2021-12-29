package com.example.sleepplan.database

import androidx.core.location.LocationRequestCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="daily_sleep_quality")
data class SleepNight(
    @PrimaryKey(autoGenerate=true)
    var nightId: Long= 0L,
    @ColumnInfo(name="start_time_milli")
    val startTimeMilli: Long=System.currentTimeMillis(),
    @ColumnInfo(name="quality_rating")
    var endTimeMilli: Long=startTimeMilli,
    var sleepQuality: Int =-1

)
