package com.example.starwarsarchive.mvp.presenter.list

import com.example.starwarsarchive.mvp.view.list.IItemView

interface ICategoryListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}