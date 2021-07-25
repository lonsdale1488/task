package com.sersh.murashevtechnicaltask.data.remote

object Common {

    private var BASE_URL = "http://gateway.marvel.com/v1/public/"
    val retrofitService: OpenMarwelApi
        get() = NetworkClient.getClient(BASE_URL).create(OpenMarwelApi::class.java)
}