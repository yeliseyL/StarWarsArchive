package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

interface SWItemResult{
    val count: Int
    val next: String
    val previous: String?
    val results: List<ISWItem>
}
