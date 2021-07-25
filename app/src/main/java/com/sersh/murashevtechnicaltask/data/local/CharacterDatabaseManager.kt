package com.sersh.murashevtechnicaltask.data.local

import com.sersh.murashevtechnicaltask.data.model.Character
import com.sersh.murashevtechnicaltask.data.model.CharacterEntity
import com.sersh.murashevtechnicaltask.data.model.Data
import com.sersh.murashevtechnicaltask.data.model.Result
import retrofit2.Response

class CharacterDatabaseManager(private val localDatabase: AppDatabase) {
    private var listCharacter = localDatabase.characterDao().all
    fun writeCharacterInDataBase(response: Response<Character>) {
        if (listCharacter.isEmpty()) {
            addCharacterInDataBase(response.body())
        } else {
            updateCharacterInDataBase(response.body())
        }
    }

    fun getCharacterFromDatabase(): Character? {
        val list = arrayListOf<Result>()
        for (i in 0..listCharacter.size-1) {
            list.add(
                Result(
                    listCharacter.get(i).id,
                    listCharacter.get(i).name,
                    listCharacter.get(i).description
                )
            )
        }
        val results: List<Result>? = list
        var character =  Character(
            Data(  0, 0, 0, 0, results
            )
        )
        return character
    }

    private fun addCharacterInDataBase(character: Character?)
    {
        if (character == null) return

        for (i in 0..character.data?.results?.size!!-1)
        {
            var res = character.data?.results!!.get(i)
            localDatabase.characterDao().insert(CharacterEntity(res.id, res.name, res.description))
        }
    }
    private fun updateCharacterInDataBase(character: Character?)
    {
        if (character == null)
        {
            return
        }
        for (i in 0..character.data?.results?.size!!-1)
        {
            var res = character.data?.results!!.get(i)
            localDatabase.characterDao().update(res.id, res.name, res.description)
        }
    }
}