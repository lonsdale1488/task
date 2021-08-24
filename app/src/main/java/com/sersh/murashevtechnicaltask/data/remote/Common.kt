package com.sersh.murashevtechnicaltask.data.remote

object Common {

    private var BASE_URL = "http://gateway.marvel.com/v1/public/"
    val retrofitService: OpenMarvelApi
        get() = NetworkClient.getClient(BASE_URL).create(OpenMarvelApi::class.java)
}