package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.view.MainView
import com.example.starwarsarchive.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var router : Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(Screens.MainScreen())
    }

    fun backClicked() {
        router.exit()
    }
}