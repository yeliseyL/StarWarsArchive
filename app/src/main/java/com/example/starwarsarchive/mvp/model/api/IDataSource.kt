package com.example.starwarsarchive.mvp.model.api

import com.example.starwarsarchive.mvp.model.entity.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("people")
    fun getPeople(@Query("page") currentPage: Int): Single<PeopleResult>

    @GET("planets")
    fun getPlanets(@Query("page") currentPage: Int): Single<PlanetsResult>

    @GET("films")
    fun getFilms(@Query("page") currentPage: Int): Single<FilmsResult>

    @GET("species")
    fun getSpecies(@Query("page") currentPage: Int): Single<SpeciesResult>

    @GET("vehicles")
    fun getVehicles(@Query("page") currentPage: Int): Single<VehiclesResult>

    @GET("starships")
    fun getStarships(@Query("page") currentPage: Int): Single<StarshipsResult>

}