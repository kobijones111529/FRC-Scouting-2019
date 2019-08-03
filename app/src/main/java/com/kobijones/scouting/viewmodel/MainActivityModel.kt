package com.kobijones.scouting.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel() {
    private val eventCodeLiveData = MutableLiveData<String>()
    var eventCode : String?
    get() = eventCodeLiveData.value
    set(value) {
            eventCodeLiveData.value = value
        }

    private val matchTypeLiveData = MutableLiveData<String>()
    var matchType : String?
    get() = matchTypeLiveData.value
    set(value) {
            matchTypeLiveData.value = value
        }

    private val matchNumberLiveData = MutableLiveData<Int>()
    var matchNumber : Int?
    get() = matchNumberLiveData.value
    set(value) {
        matchNumberLiveData.value = value
    }

    private val teamNumberLiveData = MutableLiveData<Int>()
    var teamNumber : Int?
    get() = teamNumberLiveData.value
    set(value) {
        teamNumberLiveData.value = value
    }
}