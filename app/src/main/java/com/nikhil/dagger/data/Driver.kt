package com.nikhil.dagger.data

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


class Driver {
    companion object{
        private const val TAG = "Driver"
    }
    fun drive(){
        Log.d(TAG, "driver is driving the car and he is $this")
    }
}