package com.sersh.murashevtechnicaltask.data.local

import com.sersh.murashevtechnicaltask.MurashevTechnicalTaskApp


object DataBaseManager {
    private var localDatabase: AppDatabase = MurashevTechnicalTaskApp.instance!!.db

    val characterDatabaseManager = CharacterDatabaseManager(localDatabase)
    val detailCharacterDatabaseManage = DetailCharacterDatabaseManager(localDatabase)


}