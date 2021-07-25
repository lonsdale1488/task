package com.sersh.murashevtechnicaltask.data.model

import androidx.room.*
import androidx.room.PrimaryKey


@Entity(tableName = "CharacterEntity")
class CharacterEntity
constructor( id: Int, name: String?, description: String?)
{
  @PrimaryKey(autoGenerate = false)
    var id: Int = id
    var name: String? = name
    var description: String? = description
}

