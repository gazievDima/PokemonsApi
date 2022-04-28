package com.gaziev.pokemons

import android.app.Application
import com.gaziev.pokemons.di.component.AppComponent
import com.gaziev.pokemons.di.component.DaggerAppComponent

class App : Application() {

    lateinit var daggerAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.create()
    }
}