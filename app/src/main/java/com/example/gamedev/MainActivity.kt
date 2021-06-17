package com.example.gamedev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        this.setTitle(R.string.tytul)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {//coś tam
        when (item.itemId) {
            R.id.nav_start -> {
                intent = Intent(this, GameDevStudioActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_info -> {
                intent = Intent(this, GameDevWorkActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_contact -> {
                intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    fun pdfviewerek(view:View){
        val intent=Intent(this, PdfActivity::class.java)
        startActivity(intent) // pdf
    }
    fun mapping(view:View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)//xDDDD
    }
}
