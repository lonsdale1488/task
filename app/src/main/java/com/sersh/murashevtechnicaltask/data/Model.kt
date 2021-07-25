package com.sersh.murashevtechnicaltask.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sersh.murashevtechnicaltask.MurashevTechnicalTaskApp
import com.sersh.murashevtechnicaltask.data.local.AppDatabase
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

    private var localDatabase: AppDatabase = MurashevTechnicalTaskApp.instance!!.db

    private val dataBaseManager = DataBaseManager

    private val LOG_TAG = "Model"

    private val characterLiveData: MutableLiveData<Character> = MutableLiveData<Character>()
    private val DETEIL_CHARACTER_LIVE_DATA: MutableLiveData<DeteilCharacter?> = MutableLiveData<DeteilCharacter?>()

    private val openMarwelApi = Common.retrofitService


    fun getCharacter(): MutableLiveData<Character> {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = openMarwelApi.getCharacter().awaitResponse()
                if (response.isSuccessful) {
                    Log.d(LOG_TAG, "id+ " + "is isSuccessful")
                    withContext(Dispatchers.Main) {
                        characterLiveData.setValue(response.body())
                        dataBaseManager.characterDatabaseManager.writeCharacterInDataBase(response)
                    }
                }
            } catch (e: IOException) {
                Log.d(LOG_TAG, "IOException " + e.message)
                if (dataBaseManager.characterDatabaseManager.getCharacterFromDatabase() != null)
                {
                    characterLiveData.postValue(
                        dataBaseManager.characterDatabaseManager.getCharacterFromDatabase())
                }

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
                        withContext(Dispatchers.Main) {
                            DETEIL_CHARACTER_LIVE_DATA.setValue(response.body())
                            dataBaseManager.detailCharacterDatabaseManage.writeCharacterInDataBase(response, id)
                        }
                    }
                }
            } catch (e: IOException) {
                Log.d(LOG_TAG, "IOException " + e.message)
//                if (dataBaseManager.detailCharacterDatabaseManage.getDetailCharacterByID(id) != null)
             //   {
                    DETEIL_CHARACTER_LIVE_DATA.postValue(
                        dataBaseManager.detailCharacterDatabaseManage.getDetailCharacterByID(id)
                    )
               // }
            }
        }
        return DETEIL_CHARACTER_LIVE_DATA
    }
}
