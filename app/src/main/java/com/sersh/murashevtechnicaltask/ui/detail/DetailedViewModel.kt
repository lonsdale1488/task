package com.sersh.murashevtechnicaltask.ui.detail


import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.sersh.murashevtechnicaltask.data.Model
import com.sersh.murashevtechnicaltask.data.model.DeteilCharacter

class DetailedViewModel (private var uId:Int) {

   var name = ObservableField<String>()
   var discription = ObservableField<String>()
   var resourceURI = ObservableField<String>()
   var uid = uId.toString()
   private val LOG_TAG = "DetailedViewModel"

   private var charaterResultLiveDataDeteil:  MutableLiveData<DeteilCharacter?>? = null
   private val model = Model

    init {
        charaterResultLiveDataDeteil = model.getCharacterDetail(uId)
    }
    fun getCharaterResultLiveData(): MutableLiveData<DeteilCharacter?>? {
        return charaterResultLiveDataDeteil
    }

    fun initData()
    {
        name.set(charaterResultLiveDataDeteil?.value?.data?.results?.get(0)?.name.toString())
        discription.set(charaterResultLiveDataDeteil?.value?.data?.results?.get(0)?.description.toString())
        resourceURI.set(charaterResultLiveDataDeteil?.value?.data?.results?.get(0)?.resourceURI.toString())
    }
}