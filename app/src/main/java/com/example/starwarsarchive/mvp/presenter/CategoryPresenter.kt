package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.view.CategoryView
import moxy.MvpPresenter

class CategoryPresenter : MvpPresenter<CategoryView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }
}