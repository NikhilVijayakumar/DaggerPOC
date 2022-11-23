package com.nikhil.dagger.di.module

import com.nikhil.dagger.data.Rims
import com.nikhil.dagger.data.Tires
import com.nikhil.dagger.data.Wheels
import dagger.Module
import dagger.Provides

@Module
abstract class WheelModule {

    companion object{

        @Provides
        fun provideRims():Rims = Rims()

        @Provides
        fun provideTires():Tires{
            val tire = Tires()
            tire.inflate()
            return tire
        }

        @Provides
        fun provideWheel(rims: Rims,tires: Tires) = Wheels(rims,tires)
    }



}