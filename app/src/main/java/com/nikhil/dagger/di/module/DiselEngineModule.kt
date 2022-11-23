package com.nikhil.dagger.di.module

import com.nikhil.dagger.data.DiselEngine
import com.nikhil.dagger.data.Engine
import dagger.Module
import dagger.Provides

@Module
class DiselEngineModule(val horsePower:Int) {

    @Provides
    fun provideEngine(): Engine = DiselEngine(horsePower)

}