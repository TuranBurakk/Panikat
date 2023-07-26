package com.infos.panikat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.infos.panikat.ui.homescreen.HomeFragment
import com.infos.panikat.ui.homescreen.HomeFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        navController = Navigation.findNavController(this, R.id.navHostFragment)
        setupWithNavController(bottomNavigationView, navController)
        bottomNavigationView.itemIconTintList = null


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    bottomNavigationView.menu.findItem(R.id.exerciseFragment).isChecked = true
                    val homePageBackground = ContextCompat.getDrawable(this, R.drawable.selected_bar)
                    bottomNavigationView.background = homePageBackground
                    val customBackground = resources.getDrawable(R.drawable.bottom_nav_item_selector, theme)
                    bottomNavigationView.itemBackground = customBackground
                }
                R.id.calmingExerciseFragment->{
                    bottomNavigationView.menu.findItem(R.id.home).isChecked = true
                    val homePageBackground = ContextCompat.getDrawable(this, R.drawable.selected_bar)
                    bottomNavigationView.background = homePageBackground
                    val customBackground = resources.getDrawable(R.drawable.bottom_nav_item_selector, theme)
                    bottomNavigationView.itemBackground = customBackground
                }
                R.id.breathingExerciseFragment -> {
                    bottomNavigationView.menu.findItem(R.id.home).isChecked = true
                    val exerciseBackground = ContextCompat.getDrawable(this, R.drawable.breating_selection)
                    bottomNavigationView.background = exerciseBackground
                    val brickBackground = resources.getDrawable(R.drawable.bottom_nav_brick_selection, theme)
                    bottomNavigationView.itemBackground = brickBackground
                }

            }
        }
        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.exerciseFragment -> supportFragmentManager.popBackStack()
                R.id.home -> navController.navigate(R.id.homeFragment)

            }
        }
    }

}