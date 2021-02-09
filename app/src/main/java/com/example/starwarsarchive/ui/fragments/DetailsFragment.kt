package com.example.starwarsarchive.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwarsarchive.App
import com.example.starwarsarchive.R
import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.presenter.CategoryPresenter
import com.example.starwarsarchive.mvp.presenter.DetailsPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.mvp.view.DetailsView
import kotlinx.android.synthetic.main.fragment_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsFragment : MvpAppCompatFragment(), DetailsView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    companion object {
        private const val DETAILS_ARG = "details"

        fun newInstance(details: String) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(DETAILS_ARG, details)
            }
        }
    }

    val presenter: DetailsPresenter by moxyPresenter {
        val details = arguments?.getSerializable(DetailsFragment.DETAILS_ARG) as String
        DetailsPresenter(details).apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun init(details: String) {
        details_text.text = details
    }
}