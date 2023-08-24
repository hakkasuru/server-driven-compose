package com.example.composesdui.core.delegate.action

import android.os.Bundle
import com.example.composesdui.api.model.action.Action
import com.example.composesdui.api.model.action.NavActionData
import com.example.composesdui.core.delegate.navigation.NavigationDelegate
import com.example.composesdui.ui.common.page.CommonPageFragment
import com.example.composesdui.ui.navigation.PageItemID

class DefaultActionDelegate(
    private val navDelegate: NavigationDelegate
) : BaseActionDelegate() {
    override fun canHandle(action: Action): Boolean {
        return action.type in listOf(
            "nav"
        )
    }

    override fun onHandle(action: Action, bundle: Bundle?) {
        when (action.type) {
            "nav" -> action.data.nav?.let { handleNavAction(it, bundle) }
            else -> {
                // do nothing
            }
        }
    }

    private fun handleNavAction(data: NavActionData, bundle: Bundle? = null) {
        val mBundle = Bundle().apply {
            bundle?.let { putAll(bundle) }
            putString(CommonPageFragment.pageArg, data.pageID)
            putSerializable("x-params", data.params)
        }
        navDelegate.openPageItem(PageItemID.ITEM_SD_PAGE, mBundle)
    }
}