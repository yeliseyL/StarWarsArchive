package com.example.starwarsarchive.di.modules

import com.example.starwarsarchive.mvp.model.api.IDataSource
import com.example.starwarsarchive.mvp.model.repo.ISWItemsRepo
import com.example.starwarsarchive.mvp.model.repo.retrofit.RetrofitSWItemsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun itemsRepo(api: IDataSource): ISWItemsRepo = RetrofitSWItemsRepo(api)
}