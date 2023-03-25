package com.itbproject.savethecat.data

import com.itbproject.savethecat.R
import com.itbproject.savethecat.model.Cat

class Datasource {
    fun loadAffirmations(): List<Cat> {
        return listOf(
            Cat("qwe", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("rty", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("uio", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("pas", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("dfg", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("hjk", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("lñz", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("xcv", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
            Cat("bnm", R.drawable.default_cat, R.string.SadCat, R.string.SadDescription),
        )
    }
}