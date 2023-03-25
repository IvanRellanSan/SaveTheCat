package com.itbproject.savethecat.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cat (
    val id: String,
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val descriptionResourceId: Int
)