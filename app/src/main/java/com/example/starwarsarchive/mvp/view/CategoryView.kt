package com.example.starwarsarchive.mvp.view

import com.example.starwarsarchive.mvp.model.Categories
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface CategoryView : MvpView {
    fun init()
    fun updateList()
    fun toggleProgress(inProgress: Boolean)
    fun showError()
}