package com.example.starwarsarchive.navigation

import com.example.starwarsarchive.ui.fragments.CategoryFragment
import com.example.starwarsarchive.ui.fragments.MainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class MainScreen() : SupportAppScreen() {
        override fun getFragment() = MainFragment.newInstance()
    }

    class CategoryScreen() : SupportAppScreen() {
        override fun getFragment() = CategoryFragment.newInstance()
    }
}