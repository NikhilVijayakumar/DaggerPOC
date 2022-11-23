package com.nikhil.dagger.di.module

import com.nikhil.dagger.data.Engine
import com.nikhil.dagger.data.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun bindEngine(petrolEngine: PetrolEngine): Engine
}