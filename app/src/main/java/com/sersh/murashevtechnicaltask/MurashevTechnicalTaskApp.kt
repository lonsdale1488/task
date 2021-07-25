package com.sersh.murashevtechnicaltask

import android.app.Application
import androidx.room.Room
import com.sersh.murashevtechnicaltask.data.local.AppDatabase
import com.sersh.murashevtechnicaltask.data.remote.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MurashevTechnicalTaskApp : Application() {
    lateinit var db: AppDatabase

    companion object {
        var instance: MurashevTechnicalTaskApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database"
        )
            .allowMainThreadQueries()
            .build()
        instance = this
    }
}