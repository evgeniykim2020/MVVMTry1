package com.evgeniykim.mvvmtry1.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val model = DataModel(textForUI = "Here's the updated text")

    val uiTextLiveData = MutableLiveData<String>()

    fun getUpdatedText() {
        val updatedText = model.textForUI
        uiTextLiveData.postValue(updatedText)
    }
}