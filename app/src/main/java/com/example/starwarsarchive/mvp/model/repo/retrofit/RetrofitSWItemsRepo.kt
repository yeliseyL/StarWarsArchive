package com.example.starwarsarchive.mvp.model.repo.retrofit

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.api.IDataSource
import com.example.starwarsarchive.mvp.model.entity.*
import com.example.starwarsarchive.mvp.model.repo.ISWItemsRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitSWItemsRepo(val api: IDataSource) : ISWItemsRepo {
//    override fun getItems(category: Categories): Single<SWItemResult> = when (category) {
//        Categories.PEOPLE -> api.getPeople().subscribeOn(Schedulers.io())
//        Categories.PLANETS -> api.getPlanets().subscribeOn(Schedulers.io())
//        Categories.STARSHIPS -> api.getStarships().subscribeOn(Schedulers.io())
//        Categories.SPECIES -> api.getSpecies().subscribeOn(Schedulers.io())
//        Categories.VEHICLES -> api.getVehicles().subscribeOn(Schedulers.io())
//        Categories.FILMS -> api.getFilms().subscribeOn(Schedulers.io())
//    }

    override fun getPeople(): Single<PeopleResult> = api.getPeople().subscribeOn(Schedulers.io())

    override fun getPlanets(): Single<PlanetsResult> = api.getPlanets().subscribeOn(Schedulers.io())

    override fun getFilms(): Single<FilmsResult> = api.getFilms().subscribeOn(Schedulers.io())

    override fun getSpecies(): Single<SpeciesResult> = api.getSpecies().subscribeOn(Schedulers.io())

    override fun getVehicles(): Single<VehiclesResult> = api.getVehicles().subscribeOn(Schedulers.io())

    override fun getStarships(): Single<StarshipsResult> = api.getStarships().subscribeOn(Schedulers.io())
//        api.getItems().subscribeOn(Schedulers.io())

}