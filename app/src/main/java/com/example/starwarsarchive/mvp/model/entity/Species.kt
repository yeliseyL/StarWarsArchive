package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
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
        @Expose override val name: String,
        @Expose val people: List<String>,
        @Expose val skin_colors: String,
        @Expose val url: String
): Parcelable, ISWItem {
        override fun toString() =
                "Name: $name\n" +
                "\n" +
                "Average height: $average_height\n" +
                "\n" +
                "Average lifespan: $average_lifespan\n" +
                "\n" +
                "Classification: $classification\n" +
                "\n" +
                "Designation: $designation\n" +
                "\n" +
                "Eye colors: $eye_colors\n" +
                "\n" +
                "Hair colors: $hair_colors\n" +
                "\n" +
                "Homeworld: $homeworld\n" +
                "\n" +
                "Language: $language\n" +
                "\n" +
                "Skin colors: $skin_colors\n"
}