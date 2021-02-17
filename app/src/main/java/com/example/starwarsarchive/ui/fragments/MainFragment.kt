package com.example.starwarsarchive.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.starwarsarchive.App
import com.example.starwarsarchive.R
import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.presenter.MainFragmentPresenter
import com.example.starwarsarchive.mvp.view.MainFragmentView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_main.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(), MainFragmentView {

    companion object {
        fun newInstance() = MainFragment()
    }

    val presenter: MainFragmentPresenter by moxyPresenter { MainFragmentPresenter().apply {
        App.instance.appComponent.inject(this)
    } }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun init() {
        people_btn.setOnClickListener { presenter.navigateToCategory(Categories.PEOPLE) }
        planets_btn.setOnClickListener { presenter.navigateToCategory(Categories.PLANETS) }
        films_btn.setOnClickListener { presenter.navigateToCategory(Categories.FILMS ) }
        species_btn.setOnClickListener { presenter.navigateToCategory(Categories.SPECIES) }
        vehicles_btn.setOnClickListener { presenter.navigateToCategory(Categories.VEHICLES) }
        starships_btn.setOnClickListener { presenter.navigateToCategory(Categories.STARSHIPS) }
    }
}