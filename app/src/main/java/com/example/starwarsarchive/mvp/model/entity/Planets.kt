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
        @Expose override val name: String,
        @Expose val orbital_period: String,
        @Expose val population: String,
        @Expose val residents: List<String>,
        @Expose val rotation_period: String,
        @Expose val surface_water: String,
        @Expose val terrain: String,
        @Expose val url: String
) : Parcelable, ISWItem {
        override fun toString() =
                "Name: $name\n" +
                "Climate: $climate\n" +
                "Diameter: $diameter\n" +
                "Gravity: $gravity\n" +
                "Orbital period: $orbital_period\n" +
                "Population: $population\n" +
                "Rotation period: $rotation_period\n" +
                "Surface_water: $surface_water\n" +
                "Terrain: $terrain\n"
}