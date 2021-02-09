package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class People(
        @Expose val birth_year: String,
        @Expose val created: String,
        @Expose val edited: String,
        @Expose val eye_color: String,
        @Expose val films: List<String>,
        @Expose val gender: String,
        @Expose val hair_color: String,
        @Expose val height: String,
        @Expose val homeworld: String,
        @Expose val mass: String,
        @Expose override val name: String,
        @Expose val skin_color: String,
        @Expose val species: List<String?>,
        @Expose val starships: List<String>,
        @Expose val url: String,
        @Expose val vehicles: List<String>
) : Parcelable, ISWItem {
        override fun toString() =
                "Name: $name\n" +
                "Birth year: $birth_year\n" +
                "Eye color: $eye_color\n" +
                "Gender: $gender\n" +
                "Hair color: $hair_color\n" +
                "Height: $height\n" +
                "Mass: $mass\n" +
                "Skin color: $skin_color\n"
}