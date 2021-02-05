package com.example.starwarsarchive.mvp.model.api

import com.example.starwarsarchive.mvp.model.entity.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataSource {
    @GET("people")
    fun getPeople(): Single<PeopleResult>

    @GET("planets")
    fun getPlanets(): Single<PlanetsResult>

    @GET("films")
    fun getFilms(): Single<FilmsResult>

    @GET("species")
    fun getSpecies(): Single<SpeciesResult>

    @GET("vehicles")
    fun getVehicles(): Single<VehiclesResult>

    @GET("starships")
    fun getStarships(): Single<StarshipsResult>

}