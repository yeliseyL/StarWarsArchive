package com.example.starwarsarchive.navigation

import com.example.starwarsarchive.mvp.model.Categories
import com.example.starwarsarchive.ui.fragments.CategoryFragment
import com.example.starwarsarchive.ui.fragments.DetailsFragment
import com.example.starwarsarchive.ui.fragments.MainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class MainScreen() : SupportAppScreen() {
        override fun getFragment() = MainFragment.newInstance()
    }

    class CategoryScreen(val category: Categories) : SupportAppScreen() {
        override fun getFragment() = CategoryFragment.newInstance(category)
    }

    class DetailsScreen(val details: String) : SupportAppScreen() {
        override fun getFragment() = DetailsFragment.newInstance(details)
    }
}