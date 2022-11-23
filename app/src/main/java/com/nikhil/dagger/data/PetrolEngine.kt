package com.nikhil.dagger.data

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine @Inject constructor(@Named("horsePower") val horsePower:Int,
                                       @Named("engineCapacity") val engineCapacity:Int) : Engine  {

    companion object {
        private const val TAG = "PetrolEngine"
    }

    override fun start() {
        Log.d(TAG, "PetrolEngine started with horsePower of $horsePower and engineCapacity of $engineCapacity")
    }
}