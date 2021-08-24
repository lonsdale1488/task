package com.sersh.murashevtechnicaltask.data.model


data class ThumbnailId(
    var path: String? = null,
    var extension: String? = null
)

data class ItemId(
    var resourceURI: String? = null,
    var name: String? = null,
    var type: String? = null
)

data class ComicsId(
    var available: Int = 0,
    var collectionURI: String? = null,
    var items: List<ItemId>? = null,
    var returned: Int = 0
)

data class SeriesId(
    var available: Int = 0,
    var collectionURI: String? = null,
    var items: List<ItemId>? = null,
    var returned: Int = 0
)

data class StoriesId(
    var available: Int = 0,
    var collectionURI: String? = null,
    var items: List<ItemId>? = null,
    var returned: Int = 0
)

data class EventsId(
    var available: Int = 0,
    var collectionURI: String? = null,
    var items: List<Any>? = null,
    var returned: Int = 0
)

data class UrlId(
    var type: String? = null,
    var url: String? = null
)

data class ResultId(
    var id: Int = 0,
    var name: String? = null,
    var description: String? = null,
//    var thumbnail: ThumbnailId? = null,
    var resourceURI: String? = null,
//    var comics: ComicsId? = null,
//    var series: SeriesId? = null,
//    var stories: StoriesId? = null,
//    var events: EventsId? = null,
    var urls: List<UrlId>? = null
)

data class DataId(
//    var offset :Int = 0,
//    var limit:Int = 0,
//    var total:Int = 0,
//    var count:Int = 0,
    var results: List<ResultId>? = null
)

data class DeteilCharacter(
//    var code :Int = 0,
//    var status: String? = null,
//    var copyright: String? = null,
//    var attributionText: String? = null,
//    var attributionHTML: String? = null,
//    var etag: String? = null,
    var data: DataId? = null
)