package com.example.composesdui.core.delegate.ui

import android.util.Log
import com.example.composesdui.api.model.action.Action
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UIDelegateImpl : UIDelegate {
    override val _actionFlow: MutableStateFlow<Action?> = MutableStateFlow(null)
    override val actionFlow: StateFlow<Action?>
        get() = _actionFlow.asStateFlow()

    override suspend fun onClick(action: Action) {
        _actionFlow.value = action
    }
}