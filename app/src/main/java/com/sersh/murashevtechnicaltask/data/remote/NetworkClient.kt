package com.sersh.murashevtechnicaltask.data.remote


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private var BASE_URL = "http://gateway.marvel.com/v1/public/"
    private var mRetrofit: Retrofit? = null

    fun getClient ( baseURL: String): Retrofit
    {
        if (mRetrofit == null)
        {
            mRetrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return mRetrofit!!
    }
}