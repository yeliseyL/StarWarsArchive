package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Species(
        @Expose val average_height: String,
        @Expose val average_lifespan: String,
        @Expose val classification: String,
        @Expose val created: String,
        @Expose val designation: String,
        @Expose val edited: String,
        @Expose val eye_colors: String,
        @Expose val films: List<String>,
        @Expose val hair_colors: String,
        @Expose val homeworld: String,
        @Expose val language: String,
        @Expose val name: String,
        @Expose val people: List<String>,
        @Expose val skin_colors: String,
        @Expose val url: String
): Parcelable