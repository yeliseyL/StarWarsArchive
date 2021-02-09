package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.mvp.view.DetailsView
import com.example.starwarsarchive.navigation.Screens
import moxy.MvpPresenter

class DetailsPresenter(private val details: String) : MvpPresenter<DetailsView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(details)
    }
}