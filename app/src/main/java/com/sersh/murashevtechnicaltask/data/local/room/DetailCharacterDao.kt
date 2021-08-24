package com.sersh.murashevtechnicaltask.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sersh.murashevtechnicaltask.data.model.DetailCharacterEntity


@Dao
interface DetailCharacterDao {
    @get:Query("SELECT * FROM DetailCharacterEntity")
    val all: List<DetailCharacterEntity>

    @Query("SELECT * FROM DetailCharacterEntity WHERE id = :id")
    fun findById(id: Int): DetailCharacterEntity?

    @Insert
    fun insert(mo: DetailCharacterEntity)

    @Query("UPDATE DetailCharacterEntity SET name=:name, description=:description, resource_uri=:resourceURI WHERE id = :id")
    fun update(id: Int, name: String?, description: String?, resourceURI: String?)

}