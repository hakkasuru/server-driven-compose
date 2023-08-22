package com.example.composesdui.api.model.component

import com.example.composesdui.api.model.action.Action

abstract class BaseComponent {
    var type: String = ""
    var action: Action? = null
}