package com.gaziev.pokemons

import android.app.Application
import com.gaziev.pokemons.di.AppComponent
import com.gaziev.pokemons.di.DaggerAppComponent

class App : Application() {

    lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.create()
    }
}