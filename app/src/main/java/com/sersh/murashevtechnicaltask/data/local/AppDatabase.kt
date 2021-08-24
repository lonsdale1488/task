package com.sersh.murashevtechnicaltask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sersh.murashevtechnicaltask.data.local.room.CharacterDao
import com.sersh.murashevtechnicaltask.data.local.room.DetailCharacterDao
import com.sersh.murashevtechnicaltask.data.model.CharacterEntity
import com.sersh.murashevtechnicaltask.data.model.DetailCharacterEntity

@Database(
    entities = [CharacterEntity::class, DetailCharacterEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun detailCharacterDao(): DetailCharacterDao
}