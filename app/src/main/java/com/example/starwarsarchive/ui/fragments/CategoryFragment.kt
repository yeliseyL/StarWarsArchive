package com.example.starwarsarchive.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwarsarchive.App
import com.example.starwarsarchive.R
import com.example.starwarsarchive.mvp.presenter.CategoryPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CategoryFragment : MvpAppCompatFragment(), CategoryView {

    companion object {
        fun newInstance() = CategoryFragment()
    }

    val presenter: CategoryPresenter by moxyPresenter {
        CategoryPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun init() {
    }
}