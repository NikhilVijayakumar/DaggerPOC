package com.nikhil.dagger.data

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor()  {
    companion object{
        private const val TAG = "Remote"
    }

   var listner:Car?=null
       set(value:Car?) {
           field = value
          Log.d(TAG, "car is connected to remote $listner")
       }


          fun lockCar(){
      Log.d(TAG, "car is locked")
  }

    fun unlockCar(){
        Log.d(TAG, "car is unlocked")
    }

}