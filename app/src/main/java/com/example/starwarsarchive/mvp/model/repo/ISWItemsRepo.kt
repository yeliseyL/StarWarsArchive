package com.example.starwarsarchive.mvp.model.repo

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.mvp.model.entity.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ISWItemsRepo {
    fun getPeople(currentPage: Int): Single<PeopleResult>
    fun getPlanets(currentPage: Int): Single<PlanetsResult>
    fun getFilms(currentPage: Int): Single<FilmsResult>
    fun getSpecies(currentPage: Int): Single<SpeciesResult>
    fun getVehicles(currentPage: Int): Single<VehiclesResult>
    fun getStarships(currentPage: Int): Single<StarshipsResult>
}
