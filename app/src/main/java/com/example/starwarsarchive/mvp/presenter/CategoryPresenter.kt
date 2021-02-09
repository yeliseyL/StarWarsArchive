package com.example.starwarsarchive.mvp.presenter

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
import com.example.starwarsarchive.mvp.model.repo.ISWItemsRepo
import com.example.starwarsarchive.mvp.presenter.list.ICategoryListPresenter
import com.example.starwarsarchive.mvp.view.CategoryView
import com.example.starwarsarchive.mvp.view.list.IItemView
import com.example.starwarsarchive.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
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

        categoryListPresenter.itemClickListener = {itemView ->
            val item = categoryListPresenter.items[itemView.pos]
            router.navigateTo(Screens.DetailsScreen(item.toString()))
        }
    }

    private fun loadData() {
        when(category) {
            Categories.PEOPLE -> itemsRepo.getPeople()
            Categories.PLANETS -> itemsRepo.getPlanets()
            Categories.STARSHIPS -> itemsRepo.getStarships()
            Categories.SPECIES -> itemsRepo.getSpecies()
            Categories.VEHICLES ->  itemsRepo.getVehicles()
            Categories.FILMS -> itemsRepo.getFilms()
        }.observeOn(mainThreadScheduler)
                .subscribe({ items ->
                    categoryListPresenter.items.clear()
                    categoryListPresenter.items.addAll(items.results)
                    viewState.updateList()
                }, {
                    println("Error: ${it.message}")
                })
    }
}