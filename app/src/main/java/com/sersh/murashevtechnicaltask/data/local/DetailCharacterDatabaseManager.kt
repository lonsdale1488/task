package com.sersh.murashevtechnicaltask.data.local

import com.sersh.murashevtechnicaltask.data.model.*
import com.sersh.murashevtechnicaltask.data.model.DataId
import com.sersh.murashevtechnicaltask.data.model.DeteilCharacter
import com.sersh.murashevtechnicaltask.data.model.ResultId
import retrofit2.Response

class DetailCharacterDatabaseManager (private val localDatabase: AppDatabase){
    private var listDetailCharacterCharacter = localDatabase.detailCharacterDao().all


    fun writeCharacterInDataBase(response: Response<DeteilCharacter>, id:Int) {

        if (checkId(id))
        {
            updateCharacterInDataBase(response.body(), id)
        } else{
            addCharacterInDataBase(response.body(), id)
        }

    }

    fun getDetailCharacterByID(id:Int): DeteilCharacter? {
        val characterCharacterById: DetailCharacterEntity =
            localDatabase.detailCharacterDao().findById(id) ?: return null
        val list = arrayListOf<ResultId>()
        list.add(
            ResultId(
                id,
                characterCharacterById.name,
                characterCharacterById.description,
                characterCharacterById.resourceURI
            )
        )
        val results = DeteilCharacter(
            DataId(list)
        )

        return results
    }

    private fun addCharacterInDataBase(detailCharacter: DeteilCharacter?, id: Int)
    {
        if (detailCharacter == null) return
        val res = detailCharacter.data?.results!!.get(0)

            localDatabase.detailCharacterDao().insert(DetailCharacterEntity(id, res.name, res.description, res.resourceURI ))
}
    private fun updateCharacterInDataBase(detailCharacter: DeteilCharacter?, id: Int)
    {
        if (detailCharacter == null) return

        val res = detailCharacter.data?.results!!.get(0)
        localDatabase.detailCharacterDao().update(id, res.name, res.description, res.resourceURI )
    }
    private fun checkId(id:Int):Boolean
    {   if (listDetailCharacterCharacter.isEmpty()) return false
        for (i in 0..listDetailCharacterCharacter.size-1)
        {
          if (listDetailCharacterCharacter.get(i).id == id)  return true
        }
        return false
    }
}