package com.example.starwarsarchive.mvp.model.entity.interfaces

interface ISWItemResult{
    val count: Int
    val next: String?
    val previous: String?
    val results: List<ISWItem>
}
