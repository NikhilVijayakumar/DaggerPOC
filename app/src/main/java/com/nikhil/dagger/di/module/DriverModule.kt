package com.nikhil.dagger.di.module

import com.nikhil.dagger.data.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DriverModule {
    companion object{
        @Singleton
        @Provides
        fun provideDriver() = Driver()
    }

}