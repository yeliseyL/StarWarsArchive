package com.example.starwarsarchive.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.starwarsarchive.App
import com.example.starwarsarchive.R
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
        people_btn.setOnClickListener { presenter.navigateToCategory() }
        planets_btn.setOnClickListener { presenter.navigateToCategory() }
        films_btn.setOnClickListener { presenter.navigateToCategory() }
        species_btn.setOnClickListener { presenter.navigateToCategory() }
        vehicles_btn.setOnClickListener { presenter.navigateToCategory() }
        starships_btn.setOnClickListener { presenter.navigateToCategory() }
    }



//    override fun onClick(v: View?) {
//        when(v) {
//            people_btn -> Toast.makeText(context, "Clicked 1", Toast.LENGTH_SHORT).show()
//            planets_btn -> presenter.navigateToCategory()
//            films_btn -> presenter.navigateToCategory()
//            species_btn -> presenter.navigateToCategory()
//            vehicles_btn -> presenter.navigateToCategory()
//            starships_btn -> presenter.navigateToCategory()
//        }
//    }
}