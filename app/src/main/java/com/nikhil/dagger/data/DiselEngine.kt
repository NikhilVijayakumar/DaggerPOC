package com.nikhil.dagger.data

import android.util.Log


class DiselEngine(val horsePower:Int)  : Engine {

    companion object {
        private const val TAG = "DiselEngine"
    }

    override fun start() {
        Log.d(TAG, "DiselEngine started and horsepoert is $horsePower")
    }
}