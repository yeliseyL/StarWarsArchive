package com.example.starwarsarchive.mvp.model.repo.retrofit

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.api.IDataSource
import com.example.starwarsarchive.mvp.model.entity.*
import com.example.starwarsarchive.mvp.model.repo.ISWItemsRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitSWItemsRepo(val api: IDataSource) : ISWItemsRepo {

    override fun getPeople(currentPage: Int): Single<PeopleResult> = api.getPeople(currentPage).subscribeOn(Schedulers.io())

    override fun getPlanets(currentPage: Int): Single<PlanetsResult> = api.getPlanets(currentPage).subscribeOn(Schedulers.io())

    override fun getFilms(currentPage: Int): Single<FilmsResult> = api.getFilms(currentPage).subscribeOn(Schedulers.io())

    override fun getSpecies(currentPage: Int): Single<SpeciesResult> = api.getSpecies(currentPage).subscribeOn(Schedulers.io())

    override fun getVehicles(currentPage: Int): Single<VehiclesResult> = api.getVehicles(currentPage).subscribeOn(Schedulers.io())

    override fun getStarships(currentPage: Int): Single<StarshipsResult> = api.getStarships(currentPage).subscribeOn(Schedulers.io())
}