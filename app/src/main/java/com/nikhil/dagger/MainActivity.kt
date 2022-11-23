package com.nikhil.dagger

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import com.nikhil.dagger.data.Car
import com.nikhil.dagger.databinding.ActivityMainBinding
import com.nikhil.dagger.di.component.DieselCarComponent
import com.nikhil.dagger.di.module.DiselEngineModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        init()

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    private fun init() {

        /*
        //DieselCarComponent is a component and AppComponent as dependency
        (application as PocApplication).apply {
             val component: DieselCarComponent = DaggerDieselCarComponent.builder()
                 .dieselEngineModule(DiselEngineModule(40))
                 .appComponent(appComponent)
                 .engineCapcity(3000)
                 .build()
             component.inject(this@MainActivity)
             car2.drive()
         }*/

        /*
         //DieselCarComponent  is a Subcomponent without builder
        (application as PocApplication).apply{
             val component: DieselCarComponent =   appComponent.getDieselCarComponent(DiselEngineModule(20))
             component.inject(this@MainActivity)
             car2.drive()
         }*/
/*
        //DieselCarComponent  is a Subcomponent with builder
        (application as PocApplication).apply {
            val component: DieselCarComponent = appComponent
                .getDieselCarComponent()
                .dieselEngineModule(DiselEngineModule(40))
                .engineCapcity(3000)
                .build()
            component.inject(this@MainActivity)
            car2.drive()
        }*/

        //DieselCarComponent  is a Subcomponent with factory
        (application as PocApplication).apply {
            val component: DieselCarComponent = appComponent
                .getDieselCarComponent()
                .create(2000,DiselEngineModule(40))
            component.inject(this@MainActivity)
            car2.drive()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}