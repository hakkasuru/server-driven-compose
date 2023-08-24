package com.example.composesdui.core.delegate.ui

import com.example.composesdui.api.model.action.Action
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface UIDelegate {
    val _actionFlow: MutableStateFlow<Action?>
    val actionFlow: StateFlow<Action?>

    suspend fun onClick(action: Action)
}