package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItemResult
import com.example.starwarsarchive.mvp.model.repo.ISWItemsRepo
import com.example.starwarsarchive.mvp.presenter.list.ICategoryListPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.mvp.view.list.IItemView
import com.example.starwarsarchive.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
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
    private var hasNext = true
    private var searchName = ""

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
                    if (items.next == null) hasNext = false
                    viewState.toggleProgress(false)
                    viewState.updateList()
                }, {
                    viewState.showError()
                })

    }

    fun loadNextPage() {
        if (hasNext) {
            when(category) {
                Categories.PEOPLE -> nextPage { itemsRepo.getPeople(page) as Single<ISWItemResult> }
                Categories.PLANETS -> nextPage { itemsRepo.getPlanets(page) as Single<ISWItemResult> }
                Categories.STARSHIPS -> nextPage { itemsRepo.getStarships(page) as Single<ISWItemResult> }
                Categories.SPECIES -> nextPage { itemsRepo.getSpecies(page) as Single<ISWItemResult> }
                Categories.VEHICLES ->  nextPage { itemsRepo.getVehicles(page) as Single<ISWItemResult> }
                Categories.FILMS -> nextPage { itemsRepo.getFilms(page) as Single<ISWItemResult> }
            }
        }
    }

    private fun nextPage(getItem: (Int) -> Single<ISWItemResult>) {
        viewState.toggleProgress(true)
        page++
        getItem(page).observeOn(mainThreadScheduler)
                .subscribe({ items ->
                    categoryListPresenter.items.addAll(items.results)
                    if (items.next == null) hasNext = false
                    viewState.toggleProgress(false)
                    viewState.updateList()
                }, {
                    viewState.showError()
                })
    }

    fun loadSearchData(name: String) {
        categoryListPresenter.items.clear()
        hasNext = true
        searchName = name
        page = 1
        viewState.toggleProgress(true)
        when(category) {
            Categories.PEOPLE -> itemsRepo.searchPeople(searchName, page)
            Categories.PLANETS -> itemsRepo.searchPlanets(searchName, page)
            Categories.STARSHIPS -> itemsRepo.searchStarships(searchName, page)
            Categories.SPECIES -> itemsRepo.searchSpecies(searchName, page)
            Categories.VEHICLES ->  itemsRepo.searchVehicles(searchName, page)
            Categories.FILMS -> itemsRepo.searchFilms(searchName, page)
        }.observeOn(mainThreadScheduler)
                .subscribe({ items ->
                    categoryListPresenter.items.clear()
                    categoryListPresenter.items.addAll(items.results)
                    if (items.next == null) hasNext = false
                    viewState.toggleProgress(false)
                    viewState.updateList()
                }, {
                    viewState.showError()
                })

    }

    fun loadNextSearchPage() {
        if (hasNext) {
            when (category) {
                Categories.PEOPLE -> nextSearchPage { _: String, page: Int -> itemsRepo.searchPeople(searchName, page) as Single<ISWItemResult> }
                Categories.PLANETS -> nextSearchPage { _: String, page: Int -> itemsRepo.searchPlanets(searchName, page) as Single<ISWItemResult> }
                Categories.STARSHIPS -> nextSearchPage { _: String, page: Int -> itemsRepo.searchStarships(searchName, page) as Single<ISWItemResult> }
                Categories.SPECIES -> nextSearchPage { _: String, page: Int -> itemsRepo.searchSpecies(searchName, page) as Single<ISWItemResult> }
                Categories.VEHICLES -> nextSearchPage { _: String, page: Int -> itemsRepo.searchVehicles(searchName, page) as Single<ISWItemResult> }
                Categories.FILMS -> nextSearchPage { _: String, page: Int -> itemsRepo.searchFilms(searchName, page) as Single<ISWItemResult> }
            }
        }
    }

    private fun nextSearchPage(searchItem: (String, Int) -> Single<ISWItemResult>) {
        viewState.toggleProgress(true)
        page++
        searchItem(searchName, page).observeOn(mainThreadScheduler)
                .subscribe({ items ->
                    categoryListPresenter.items.addAll(items.results)
                    if (items.next == null) hasNext = false
                    viewState.toggleProgress(false)
                    viewState.updateList()
                }, {
                    viewState.showError()
                })
    }

    fun navigateBack() {
        router.exit()
    }
}