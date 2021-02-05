package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Starships(
        @Expose val MGLT: String,
        @Expose val cargo_capacity: String,
        @Expose val consumables: String,
        @Expose val cost_in_credits: String,
        @Expose val created: String,
        @Expose val crew: String,
        @Expose val edited: String,
        @Expose val films: List<String>,
        @Expose val hyperdrive_rating: String,
        @Expose val length: String,
        @Expose val manufacturer: String,
        @Expose val max_atmosphering_speed: String,
        @Expose val model: String,
        @Expose val name: String,
        @Expose val passengers: String,
        @Expose val pilots: List<String?>,
        @Expose val starship_class: String,
        @Expose val url: String
): Parcelable