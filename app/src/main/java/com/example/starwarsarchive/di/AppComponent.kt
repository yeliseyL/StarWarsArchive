package com.example.starwarsarchive.di

import com.example.starwarsarchive.di.modules.ApiModule
import com.example.starwarsarchive.di.modules.AppModule
import com.example.starwarsarchive.di.modules.CiceroneModule
import com.example.starwarsarchive.mvp.presenter.CategoryPresenter
import com.example.starwarsarchive.mvp.presenter.MainFragmentPresenter
import com.example.starwarsarchive.mvp.presenter.MainPresenter
import com.example.starwarsarchive.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ApiModule::class,
            AppModule::class,
            CiceroneModule::class,
        ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(mainFragmentPresenter: MainFragmentPresenter)
    fun inject(categoryPresenter: CategoryPresenter)
}