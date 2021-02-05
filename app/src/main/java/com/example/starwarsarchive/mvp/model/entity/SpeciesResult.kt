package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class SpeciesResult(
        @Expose val count: Int,
        @Expose val next: String,
        @Expose val previous: String?,
        @Expose val results: List<Species>
) : Parcelable