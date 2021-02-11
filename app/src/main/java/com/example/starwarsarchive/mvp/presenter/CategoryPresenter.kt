package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.entity.People
import com.example.starwarsarchive.mvp.model.entity.PeopleResult
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
import com.example.starwarsarchive.mvp.model.repo.ISWItemsRepo
import com.example.starwarsarchive.mvp.presenter.list.ICategoryListPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.mvp.view.list.IItemView
import com.example.starwarsarchive.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class CategoryPresenter(private val category: Categories) : MvpPresenter<CategoryView>() {

    @Inject
    lateinit var itemsRepo: ISWItemsRepo

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var mainThreadScheduler: Scheduler

    private val defaultPage = 1
    private var page = defaultPage
    private val compositeDisposable = CompositeDisposable()
    var hasNext = true

    class CategoryListPresenter : ICategoryListPresenter<IItemView> {
        val items = mutableListOf<ISWItem>()

        override var itemClickListener: ((IItemView) -> Unit)? = null

        override fun getCount() = items.size

        override fun bindView(view: IItemView) {
            val item = items[view.pos]

            item.name.let { view.setTitle(it) }
        }
    }

    val categoryListPresenter = CategoryListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        categoryListPresenter.itemClickListener = { itemView ->
            val item = categoryListPresenter.items[itemView.pos]
            router.navigateTo(Screens.DetailsScreen(item.toString()))
        }
    }

    private fun loadData() {
        viewState.toggleProgress(true)
        when(category) {
            Categories.PEOPLE -> itemsRepo.getPeople(page)
            Categories.PLANETS -> itemsRepo.getPlanets(page)
            Categories.STARSHIPS -> itemsRepo.getStarships(page)
            Categories.SPECIES -> itemsRepo.getSpecies(page)
            Categories.VEHICLES ->  itemsRepo.getVehicles(page)
            Categories.FILMS -> itemsRepo.getFilms(page)
        }.observeOn(mainThreadScheduler)
                .subscribe({ items ->
                    categoryListPresenter.items.clear()
                    categoryListPresenter.items.addAll(items.results)
                    viewState.toggleProgress(false)
                    viewState.updateList()
                }, {
                    println("Error: ${it.message}")
                })

    }

    fun loadNextPage() {
        if (hasNext) {
            viewState.toggleProgress(true)
            page++
            itemsRepo.getPeople(page).observeOn(mainThreadScheduler)
                .subscribe({ items ->
                    categoryListPresenter.items.addAll(items.results)
                    if (items.next == null) hasNext = false
                    viewState.toggleProgress(false)
                    viewState.updateList()
                }, {
                    println("Error: ${it.message}")
                })
        }
    }

}