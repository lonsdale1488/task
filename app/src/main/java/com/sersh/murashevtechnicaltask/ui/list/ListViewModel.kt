package com.sersh.murashevtechnicaltask.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sersh.murashevtechnicaltask.data.Model
import com.sersh.murashevtechnicaltask.data.model.Character


class ListViewModel: ViewModel() {
    private var charaterResultLiveData:  MutableLiveData<Character>? = null
    private val model = Model

    init {
        charaterResultLiveData = model.getCharacter()
    }

    fun getCharaterResultLiveData(): MutableLiveData<Character>? {
        return charaterResultLiveData
    }
}