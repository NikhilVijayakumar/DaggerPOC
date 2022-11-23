package com.nikhil.dagger

import android.app.Application

import com.nikhil.dagger.di.component.AppComponent
import com.nikhil.dagger.di.component.DaggerAppComponent


class PocApplication:Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerAppComponent.create()
    }


}