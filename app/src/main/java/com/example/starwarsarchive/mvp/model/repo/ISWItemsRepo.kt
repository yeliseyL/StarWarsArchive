package com.example.starwarsarchive.mvp.model.repo

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.entity.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ISWItemsRepo {
//    fun getItems(category: Categories): Single<SWItemResult>
    fun getPeople(): Single<PeopleResult>
    fun getPlanets(): Single<PlanetsResult>
    fun getFilms(): Single<FilmsResult>
    fun getSpecies(): Single<SpeciesResult>
    fun getVehicles(): Single<VehiclesResult>
    fun getStarships(): Single<StarshipsResult>
}
