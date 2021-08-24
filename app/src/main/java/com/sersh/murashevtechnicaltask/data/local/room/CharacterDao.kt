package com.sersh.murashevtechnicaltask.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sersh.murashevtechnicaltask.data.model.CharacterEntity

@Dao
interface CharacterDao {

    @get:Query("SELECT * FROM CharacterEntity")
    val all: List<CharacterEntity>

    @Insert
    fun insert(mo: CharacterEntity)

    @Query("UPDATE CharacterEntity SET name=:name, description=:description WHERE id = :id")
    fun update(id: Int, name: String?, description: String?)
}