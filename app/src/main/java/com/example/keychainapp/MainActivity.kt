package com.example.keychainapp

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.navView)

        // Setup Toolbar & Garis Hamburger
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.buka_laci, R.string.tutup_laci // Tar lu tambahin aja di strings.xml
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Default layar pas pertama buka aplikasi
        if (savedInstanceState == null) {
            gantiLayar(MediaFragment())
            navView.setCheckedItem(R.id.nav_media)
        }

        // Logika pas menu diklik
        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_media -> gantiLayar(MediaFragment()) // Layar Foto & Video/GIF
                R.id.nav_text -> gantiLayar(TextFragment())   // Layar Running Text (yg kemaren gua kasih)
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun gantiLayar(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}