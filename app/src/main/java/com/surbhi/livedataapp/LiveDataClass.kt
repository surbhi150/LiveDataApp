package com.surbhi.livedataapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataClass : ViewModel(){

    var number : MutableLiveData<Int> = MutableLiveData(0)
    var color : MutableLiveData<Int> = MutableLiveData(0)
}