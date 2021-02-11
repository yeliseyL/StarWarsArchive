package com.example.starwarsarchive.mvp.model.repo

import com.example.starwarsarchive.mvp.model.entity.*
import io.reactivex.rxjava3.core.Single

interface ISWItemsRepo {
    fun getPeople(currentPage: Int): Single<PeopleResult>

    fun getPlanets(currentPage: Int): Single<PlanetsResult>

    fun getFilms(currentPage: Int): Single<FilmsResult>

    fun getSpecies(currentPage: Int): Single<SpeciesResult>

    fun getVehicles(currentPage: Int): Single<VehiclesResult>

    fun getStarships(currentPage: Int): Single<StarshipsResult>


    fun searchPeople(name: String, page: Int): Single<PeopleResult>

    fun searchPlanets(name: String, page: Int): Single<PlanetsResult>

    fun searchFilms(name: String, page: Int): Single<FilmsResult>

    fun searchSpecies(name: String, page: Int): Single<SpeciesResult>

    fun searchVehicles(name: String, page: Int): Single<VehiclesResult>

    fun searchStarships(name: String, page: Int): Single<StarshipsResult>
}
