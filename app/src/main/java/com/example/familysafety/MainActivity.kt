package com.example.familysafety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom_tab_navigator = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar);
        bottom_tab_navigator.setOnItemSelectedListener { menuItem: MenuItem ->

            // inflate fragments as per selected bottom tab
            when (menuItem.itemId) {
                R.id.menu_guard -> inflateFragment(GuardFragment.newInstance());
                R.id.menu_home -> inflateFragment(HomeFragment.newInstance());
                R.id.menu_profile -> inflateFragment(ProfileFragment.newInstance())
                R.id.menu_sos -> inflateFragment(SosFragment.newInstance())
                else -> inflateFragment(HomeFragment.newInstance());
            }
            true
        }

        // When you open the app : Default fragment is home
        if (savedInstanceState == null) {
            bottom_tab_navigator.setSelectedItemId(R.id.menu_home)
        }
    }

    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.container_bottom_tab, newInstance);
        transaction.commit();
    }
}


