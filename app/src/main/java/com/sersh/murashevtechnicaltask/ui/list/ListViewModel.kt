package com.sersh.murashevtechnicaltask.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sersh.murashevtechnicaltask.data.Model
import com.sersh.murashevtechnicaltask.data.model.Character


class ListViewModel: ViewModel() {
    private var characterResultLiveData:  MutableLiveData<Character>? = null
    private val model = Model

    init {
        characterResultLiveData = model.getCharacter()
        Log.d("MainActivity", "getCharacter()")
    }

    fun getCharaterResultLiveData(): MutableLiveData<Character>? {
        return characterResultLiveData
    }
}