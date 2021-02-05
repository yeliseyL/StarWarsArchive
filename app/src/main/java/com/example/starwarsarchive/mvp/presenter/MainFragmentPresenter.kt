package com.example.starwarsarchive.mvp.presenter

import android.util.Log
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

    fun navigateToCategory() {
        Log.d("Navigate to category", "Navigate to category")
        router.navigateTo(Screens.CategoryScreen())
    }
}