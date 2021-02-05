package com.example.starwarsarchive.di.modules

import com.example.starwarsarchive.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }
}