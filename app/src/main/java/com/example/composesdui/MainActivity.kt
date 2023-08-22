package com.example.composesdui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.composesdui.dashboard.DashboardFragment
import com.example.composesdui.ui.common.page.CommonPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var btmNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btmNavigationView = findViewById(R.id.btmNavigationView)

        btmNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dashboard -> {
                    val fragment = DashboardFragment.newInstance()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, fragment)
                    transaction.commit()
                    true
                }
                R.id.profile -> {
                    createCommonFragment("profile")
                    true
                }
                R.id.settings -> {
                    createCommonFragment("settings")
                    true
                }
                else -> false
            }
        }

        btmNavigationView.selectedItemId = R.id.dashboard
    }

    private fun createCommonFragment(page: String) {
        val fragment = CommonPageFragment.newInstance(page)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}