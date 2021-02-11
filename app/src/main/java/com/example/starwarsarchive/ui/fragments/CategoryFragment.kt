package com.example.starwarsarchive.ui.fragments


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsarchive.App
import com.example.starwarsarchive.R
import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.presenter.CategoryPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.ui.adapter.CategoryRVAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_category.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CategoryFragment : MvpAppCompatFragment(), CategoryView {

    private var inSearch = false

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

        setHasOptionsMenu(true)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    presenter.loadSearchData(s.toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        searchEditText.setOnFocusChangeListener { view, b ->  if (!b) view.hideKeyboard()}

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

                    if (!fetch_progress.isVisible && totalItemCount <= (lastVisibleItem + 1) && !inSearch) {
                        presenter.loadNextPage()
                    } else if (!fetch_progress.isVisible && totalItemCount <= (lastVisibleItem + 1) && inSearch) {
                        presenter.loadNextSearchPage()
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

    override fun showError() {
        Snackbar.make(requireView(), "Connection Error", Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                inSearch = !inSearch
                if (inSearch) searchEditText.visibility = View.VISIBLE
                else searchEditText.visibility = View.GONE
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

}