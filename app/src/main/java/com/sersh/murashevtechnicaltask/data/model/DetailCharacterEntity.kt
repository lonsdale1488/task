package com.sersh.murashevtechnicaltask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DetailCharacterEntity")
class DetailCharacterEntity
constructor(
    @PrimaryKey(autoGenerate = false) var id: Int,
    var name: String?,
    var description: String?,
    @ColumnInfo(name = "resource_uri") var resourceURI: String?
) {
}
