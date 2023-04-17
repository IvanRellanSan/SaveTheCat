package com.itbproject.savethecat.navigation

import android.content.Context
import android.content.Intent
import com.itbproject.savethecat.DetailActivity

class GridNavigator {
    fun goToDetailActivity(id: String, context: Context){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }
}