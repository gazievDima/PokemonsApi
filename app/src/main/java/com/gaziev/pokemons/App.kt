package com.gaziev.pokemons

import android.app.Application
import com.gaziev.pokemons.di.DaggerAppComponent

class App : Application() {

    val daggerAppComponent = DaggerAppComponent.create()
}