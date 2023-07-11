package com.example.usandodatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usandodatabinding.api.ServiceApi
import com.example.usandodatabinding.model.Time

class MainViewModel: ViewModel() {

    private var _times = MutableLiveData<List<Time>>()
    val time: LiveData<List<Time>> = _times

    fun getListTimes(){
        val list = ServiceApi.getListTimes()
        _times.value = list
    }

}