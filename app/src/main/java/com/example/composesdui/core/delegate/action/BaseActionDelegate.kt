package com.example.composesdui.core.delegate.action

import android.os.Bundle
import com.example.composesdui.api.model.action.Action

abstract class BaseActionDelegate : ActionDelegate {
    abstract fun canHandle(action: Action): Boolean
    abstract fun onHandle(action: Action, bundle: Bundle? = null)

    final override fun handleAction(action: Action, bundle: Bundle?) {
        onHandle(action, bundle)
    }
}