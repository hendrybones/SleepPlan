package com.example.sleepplan.sleepTracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sleepplan.database.SleepDatabaseDao

class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application):AndroidViewModel(application){



}