package com.dev.bottomnavwithmultiplenavgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dev.bottomnavwithmultiplenavgraph.base.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var navController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            setupBottomNav()

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNav()
    }

    private fun setupBottomNav() {

        val graphIds =
            listOf(R.navigation.main_nav_graph,R.navigation.settings_nav_graph,R.navigation.notifications_nav_graph)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        val controller = bottomNav.setupWithNavController(
            graphIds,
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent
        )
        controller.observe(this){
            setupActionBarWithNavController(it)
        }
        navController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.value?.navigateUp()!! || super.onSupportNavigateUp()
    }
}