package com.sersh.murashevtechnicaltask.data.model


data class Thumbnail (
    var path: String? = null,
    var extension: String? = null
)

data class Item (
    var resourceURI: String? = null,
    var name: String? = null,
    var type: String? = null
)

data class Comics (
    var available:Int = 0,
    var collectionURI: String? = null,
    var items: List<Item>? = null,
    var returned:Int = 0
)

data class Series (
    var available:Int = 0,
    var collectionURI: String? = null,
    var items: List<Item>? = null,
    var returned:Int = 0
)

data class Stories (
    var available:Int = 0,
    var collectionURI: String? = null,
    var items: List<Item>? = null,
    var returned:Int = 0
)

data class Events (
    var available:Int = 0,
    var collectionURI: String? = null,
    var items: List<Item>? = null,
    var returned:Int = 0
)

data class Url (
    var type: String? = null,
    var url: String? = null
)

data class Result (
    var id:Int = 0,
    var name: String? = null,
    var description: String? = null,
//    var thumbnail: Thumbnail? = null,
//    var resourceURI: String? = null,
//    var comics: ComicsId? = null,
//    var series: Series? = null,
//    var stories: Stories? = null,
//    var events: Events? = null,
    var urls: List<Url>? = null
)

data class Data (
    var offset:Int = 0,
    var limit:Int = 0,
    var total:Int = 0,
    var count:Int = 0,
    var results: List<Result>? = null
)

data class Character (
//    var code:Int = 0,
//    var status: String? = null,
//    var copyright: String? = null,
//    var attributionText: String? = null,
//    var attributionHTML: String? = null,
//    var etag: String? = null,
    var data: Data? = null
)