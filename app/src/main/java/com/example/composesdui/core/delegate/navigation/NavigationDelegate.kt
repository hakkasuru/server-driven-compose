package com.example.composesdui.core.delegate.navigation

import android.os.Bundle

interface NavigationDelegate {
    fun openPageItem(pageID: Int, bundle: Bundle? = null)
}