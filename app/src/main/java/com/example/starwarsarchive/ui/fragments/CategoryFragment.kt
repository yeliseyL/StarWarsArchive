package com.example.starwarsarchive.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsarchive.App
import com.example.starwarsarchive.R
import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.presenter.CategoryPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.ui.adapter.CategoryRVAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CategoryFragment : MvpAppCompatFragment(), CategoryView {

    companion object {
        private const val CATEGORY_ARG = "category"

        fun newInstance(category: Categories) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putSerializable(CATEGORY_ARG, category)
            }
        }
    }

    val presenter: CategoryPresenter by moxyPresenter {
        val category = arguments?.getSerializable(CATEGORY_ARG) as Categories
        CategoryPresenter(category).apply {
            App.instance.appComponent.inject(this)
        }
    }

    var adapter: CategoryRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun init() {
        rv_items.layoutManager = LinearLayoutManager(context)
        adapter = CategoryRVAdapter(presenter.categoryListPresenter).apply {
            App.instance.appComponent.inject(this)
        }
        rv_items.adapter = adapter
        rv_items.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                recyclerView.layoutManager?.let {

                    val linearLayoutManager = it as LinearLayoutManager
                    val totalItemCount = linearLayoutManager.itemCount
                    val lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()

                    if (!fetch_progress.isVisible && totalItemCount <= (lastVisibleItem + 1)) {
                        presenter.loadNextPage()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun toggleProgress(inProgress: Boolean) {
        when (inProgress) {
            true -> fetch_progress.visibility = View.VISIBLE
            false -> fetch_progress.visibility = View.GONE
        }
    }

}