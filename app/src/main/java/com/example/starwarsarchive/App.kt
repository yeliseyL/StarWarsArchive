package com.example.starwarsarchive

import android.app.Application
import com.example.starwarsarchive.di.AppComponent
import com.example.starwarsarchive.di.DaggerAppComponent
import com.example.starwarsarchive.di.modules.AppModule

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}