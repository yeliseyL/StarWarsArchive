package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Planets(
        @Expose val climate: String,
        @Expose val created: String,
        @Expose val diameter: String,
        @Expose val edited: String,
        @Expose val films: List<String>,
        @Expose val gravity: String,
        @Expose val name: String,
        @Expose val orbital_period: String,
        @Expose val population: String,
        @Expose val residents: List<String>,
        @Expose val rotation_period: String,
        @Expose val surface_water: String,
        @Expose val terrain: String,
        @Expose val url: String
) : Parcelable