package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Films(
        @Expose val characters: List<String>,
        @Expose val created: String,
        @Expose val director: String,
        @Expose val edited: String,
        @Expose val episode_id: Int,
        @Expose val opening_crawl: String,
        @Expose val planets: List<String>,
        @Expose val producer: String,
        @Expose val release_date: String,
        @Expose val species: List<String>,
        @Expose val starships: List<String>,
        @Expose val title: String,
        @Expose val url: String,
        @Expose val vehicles: List<String>
) : Parcelable, ISWItem {
        override val name: String
                get() = title

        override fun toString() =
                "Title: $name\n" +
                "Release date: $release_date\n" +
                "Director: $director\n" +
                "Producer: $producer\n" +
                "Opening crawl: $opening_crawl\n"
}