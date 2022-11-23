package com.nikhil.dagger.di.component

import com.nikhil.dagger.data.Driver
import com.nikhil.dagger.di.module.DiselEngineModule
import com.nikhil.dagger.di.module.DriverModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {

    fun getDriver(): Driver

    //subcomponent withput builder
    //fun getDieselCarComponent(diselEngineModule: DiselEngineModule):DieselCarComponent

    fun getDieselCarComponent():DieselCarComponent.Factory
}