package com.sersh.murashevtechnicaltask.ui.detail


import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.sersh.murashevtechnicaltask.data.Model
import com.sersh.murashevtechnicaltask.data.model.DeteilCharacter

class DetailedViewModel(uId: Int) {

    var name = ObservableField<String>()
    var description = ObservableField<String>()
    var resourceURI = ObservableField<String>()
    var uid = uId.toString()

    private var characterResultLiveDataDetail: MutableLiveData<DeteilCharacter?>? = null
    private val model = Model

    init {
        characterResultLiveDataDetail = model.getCharacterDetail(uId)
    }

    fun getCharaterResultLiveData(): MutableLiveData<DeteilCharacter?>? {
        return characterResultLiveDataDetail
    }

    fun initData() {
        name.set(characterResultLiveDataDetail?.value?.data?.results?.get(0)?.name.toString())
        description.set(characterResultLiveDataDetail?.value?.data?.results?.get(0)?.description.toString())
        resourceURI.set(characterResultLiveDataDetail?.value?.data?.results?.get(0)?.resourceURI.toString())
    }
}