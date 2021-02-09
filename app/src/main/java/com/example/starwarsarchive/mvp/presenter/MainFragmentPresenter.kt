package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.view.MainFragmentView
import com.example.starwarsarchive.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainFragmentPresenter : MvpPresenter<MainFragmentView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun navigateToCategory(category: Categories) {
        router.navigateTo(Screens.CategoryScreen(category))
    }
}