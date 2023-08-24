package com.example.composesdui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.composesdui.api.model.action.Action
import com.example.composesdui.core.delegate.action.ActionDelegate
import com.example.composesdui.core.delegate.action.ActionDelegateController
import com.example.composesdui.core.delegate.action.DefaultActionDelegate
import com.example.composesdui.core.delegate.navigation.NavigationDelegate
import com.example.composesdui.dashboard.DashboardFragment
import com.example.composesdui.ui.common.page.CommonPageFragment
import com.example.composesdui.ui.navigation.PageItemID
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), NavigationDelegate, ActionDelegate {

    private lateinit var actionDelegateController: ActionDelegateController
    private lateinit var btmNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        actionDelegateController = ActionDelegateController()

        btmNavigationView = findViewById(R.id.btmNavigationView)

        btmNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dashboard -> {
                    val fragment = DashboardFragment.newInstance()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(DashboardFragment.TAG)
                        .commit()
                    true
                }
                R.id.profile -> {
                    handleCommonFragment("profile")
                    true
                }
                R.id.settings -> {
                    handleCommonFragment("settings")
                    true
                }
                else -> false
            }
        }

        btmNavigationView.selectedItemId = R.id.dashboard

        actionDelegateController.registerDelegate(DefaultActionDelegate(this))
    }

    private fun handleCommonFragment(page: String) {
        val fragment = CommonPageFragment.newInstance(page)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
            .addToBackStack(CommonPageFragment.TAG)
            .commit()
    }

    private fun handleOverlayFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentOverlay, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

    override fun openPageItem(pageID: Int, bundle: Bundle?) {
        val fragment: Fragment? =  when (pageID) {
            PageItemID.ITEM_SD_PAGE -> {
                CommonPageFragment.newInstance(bundle)
            }
            else -> {
                null
            }
        }

        fragment?.let {
            handleOverlayFragment(it, it.javaClass.name)
        }
    }

    override fun handleAction(action: Action, bundle: Bundle?) {
       actionDelegateController.nextActionDelegate(action)?.handleAction(action, bundle)
    }
}