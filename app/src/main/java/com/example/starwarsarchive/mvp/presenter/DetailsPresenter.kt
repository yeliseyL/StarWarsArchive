package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.view.DetailsView
import moxy.MvpPresenter

class DetailsPresenter(private val details: String) : MvpPresenter<DetailsView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(details)
    }
}