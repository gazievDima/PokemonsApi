package com.gaziev.pokemons

import android.app.Application
import com.gaziev.pokemons.di.AppComponent
import com.gaziev.pokemons.di.AppModule
import com.gaziev.pokemons.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}