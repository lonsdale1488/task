package com.sersh.murashevtechnicaltask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DetailCharacterEntity")
class DetailCharacterEntity
    constructor( id:Int, name:String?, description:String?, resourceURI:String?)
    {
        @PrimaryKey(autoGenerate = false)
        var id: Int = id
        var name: String? = name
        var description: String? = description
        @ColumnInfo(name = "resource_uri")
        var resourceURI: String? = resourceURI
    }
