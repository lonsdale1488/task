package com.sersh.murashevtechnicaltask.data.model

import androidx.room.*
import androidx.room.PrimaryKey


@Entity(tableName = "CharacterEntity")
class CharacterEntity
constructor(
  @PrimaryKey(autoGenerate = false) var id: Int,
  var name: String?,
  var description: String?
)

