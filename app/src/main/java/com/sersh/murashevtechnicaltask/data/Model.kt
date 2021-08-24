package com.sersh.murashevtechnicaltask.data


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sersh.murashevtechnicaltask.data.local.DataBaseManager
import com.sersh.murashevtechnicaltask.data.model.*
import com.sersh.murashevtechnicaltask.data.model.DeteilCharacter
import com.sersh.murashevtechnicaltask.data.remote.Common
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import java.io.IOException


object Model {


    private val dataBaseManager = DataBaseManager


    private val characterLiveData: MutableLiveData<Character> = MutableLiveData()
    private val DETAIL_CHARACTER_LIVE_DATA: MutableLiveData<DeteilCharacter?> =
        MutableLiveData()

    private val openMarwelApi = Common.retrofitService


    fun getCharacter(): MutableLiveData<Character> {
        Log.d("MainActivity", "getCharacter()")
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = openMarwelApi.getCharacter().awaitResponse()
                if (response.isSuccessful) {
                    Log.d("MainActivity", "isSuccessful")
                    withContext(Dispatchers.Main) {
                        characterLiveData.value = response.body()
                        dataBaseManager.characterDatabaseManager.writeCharacterInDataBase(response)
                    }
                } else{
                    Log.d("MainActivity", "isNotSuccessful")
                }
            } catch (e: IOException) {
                e.message?.let { Log.d("MainActivity", it) }
                characterLiveData.postValue(
                    dataBaseManager.characterDatabaseManager.getCharacterFromDatabase()
                )

            }
        }
        return characterLiveData
    }

    fun getCharacterDetail(id: Int): MutableLiveData<DeteilCharacter?> {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = openMarwelApi.getCharacterId(id)?.awaitResponse()

                if (response != null) {
                    if (response.isSuccessful) {
                        Log.d("MainActivity", "isSuccessful")
                        withContext(Dispatchers.Main) {
                            DETAIL_CHARACTER_LIVE_DATA.value = response.body()
                            dataBaseManager.detailCharacterDatabaseManage.writeCharacterInDataBase(
                                response,
                                id
                            )
                        }
                    } else{
                        Log.d("MainActivity", "isNotSuccessful")
                    }
                }
            } catch (e: IOException) {

                DETAIL_CHARACTER_LIVE_DATA.postValue(
                    dataBaseManager.detailCharacterDatabaseManage.getDetailCharacterByID(id)
                )
            }
        }
        return DETAIL_CHARACTER_LIVE_DATA
    }
}
