package com.example.composesdui.core.delegate.action

import android.os.Bundle
import com.example.composesdui.api.model.action.Action

interface ActionDelegate {
    fun handleAction(action: Action, bundle: Bundle? = null)
}