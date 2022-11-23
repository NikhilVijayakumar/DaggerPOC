package com.nikhil.dagger.data

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(val driver: Driver,val engine: Engine, val wheels: Wheels) {
    companion object {
        private const val TAG = "Car"
    }

    fun drive() {
        engine.start()
        driver.drive()
        Log.d(TAG, "driver is driving and car is $this ")
    }

    @Inject
    fun enableRemote(remote: Remote) {
        remote.listner = this
    }
}