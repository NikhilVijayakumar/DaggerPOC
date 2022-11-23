package com.nikhil.dagger.di.component

import com.nikhil.dagger.FirstFragment
import com.nikhil.dagger.MainActivity
import com.nikhil.dagger.data.Car
import com.nikhil.dagger.di.module.DiselEngineModule
import com.nikhil.dagger.di.module.WheelModule
import com.nikhil.dagger.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named

@ActivityScope
@Subcomponent(
    modules = [WheelModule::class, DiselEngineModule::class]
)
interface DieselCarComponent {
    fun getCar(): Car
    fun inject(mainActivity: MainActivity)


     @Subcomponent.Factory
 interface Factory {

     fun create(@BindsInstance engineCapcity: Int,diselEngineModule: DiselEngineModule): DieselCarComponent


     //fun engineCapcity(engineCapcity: Int): Builder

     //fun dieselEngineModule(diselEngineModule: DiselEngineModule): Builder

 }


   /* @Subcomponent.Builder
    interface Builder {

        fun build(): DieselCarComponent

        @BindsInstance
        fun engineCapcity(engineCapcity: Int): Builder

        fun dieselEngineModule(diselEngineModule: DiselEngineModule): Builder

    }

*/
/*    @Component.Builder
    interface Builder {

        fun build(): DieselCarComponent

        @BindsInstance
        fun engineCapcity(engineCapcity: Int): Builder

        fun dieselEngineModule(diselEngineModule: DiselEngineModule): Builder

        fun appComponent(appComponent: AppComponent): Builder

    }*/

}