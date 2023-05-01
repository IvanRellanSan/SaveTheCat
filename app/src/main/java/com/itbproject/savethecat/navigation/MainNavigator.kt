package com.itbproject.savethecat.navigation

import android.content.Context
import android.content.Intent
import com.itbproject.savethecat.ui.views.GridActivity

class MainNavigator {
    fun goToGridActivity(context: Context){
        val intent = Intent(context, GridActivity::class.java)
        context.startActivity(intent)
    }
}