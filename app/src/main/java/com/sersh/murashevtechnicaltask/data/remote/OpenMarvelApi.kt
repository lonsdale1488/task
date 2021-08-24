package com.sersh.murashevtechnicaltask.data.remote


import com.sersh.murashevtechnicaltask.data.model.Character
import com.sersh.murashevtechnicaltask.data.model.DeteilCharacter
import com.sersh.murashevtechnicaltask.util.Constant.hash
import com.sersh.murashevtechnicaltask.util.Constant.key
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface OpenMarvelApi {


    @GET("characters?ts=1&apikey=$key&hash=$hash")
    fun getCharacter(): Call<Character>


    @GET("characters/{uid}?ts=1&apikey=$key&hash=$hash")
    fun getCharacterId(@Path("uid") id: Int): Call<DeteilCharacter>?
}
