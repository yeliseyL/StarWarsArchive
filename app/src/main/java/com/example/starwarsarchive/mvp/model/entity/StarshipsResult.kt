package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItemResult
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class StarshipsResult(
        @Expose override val count: Int,
        @Expose override val next: String?,
        @Expose override val previous: String?,
        @Expose override val results: List<Starships>
) : Parcelable, ISWItemResult
