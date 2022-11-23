package com.nikhil.dagger.di.component

import com.nikhil.dagger.FirstFragment
import com.nikhil.dagger.data.Car
import com.nikhil.dagger.di.module.PetrolEngineModule
import com.nikhil.dagger.di.module.WheelModule
import com.nikhil.dagger.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@FragmentScope
@Component(
    dependencies = [AppComponent::class],
    modules = [WheelModule::class, PetrolEngineModule::class]
)
interface PetrolCarComponent {
    fun getCar(): Car
    fun inject(firstFragment: FirstFragment)

    //Component Factory
    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance @Named("horsePower") horsePower: Int,
            @BindsInstance @Named("engineCapacity") engineCapcity: Int
        ): PetrolCarComponent
    }

    /*
    //Component builder
    @Component.Builder
    interface Builder {

        fun build(): PetrolCarComponent

        @BindsInstance
        fun horsePower(@Named("horsePower") horsePower: Int): Builder

        @BindsInstance
        fun engineCapcity(@Named("engineCapacity") engineCapcity: Int): Builder

        fun appComponent(appComponent: AppComponent): Builder

    }*/
}