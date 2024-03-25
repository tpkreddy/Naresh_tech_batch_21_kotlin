package com.nareshittechnologies.trackscoremvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel{

    var count:MutableLiveData<Int>
    constructor(){
        Log.v("MAIN","Started a new viewmodel for MainActivity")
        count = MutableLiveData()
        count.value = 0
    }

    /**This method is encountered when the activity is completely destroyed.
     * */
    override fun onCleared() {
        super.onCleared()
        Log.v("MAIN","Destroyed a viewmodel for MainActivity")
    }

    fun incrementCount(){
        count.value = count.value?.plus(1)
    }

    fun decrementCount(){
        count.value = count.value?.minus(1)
    }
}