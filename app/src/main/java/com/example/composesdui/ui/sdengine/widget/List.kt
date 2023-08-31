package com.example.composesdui.ui.sdengine.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.composesdui.api.model.widget.ListWidget
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.sdengine.ComponentEngine

@Composable
fun ListWidgetComposable(widget: ListWidget, uiDelegate: UIDelegate) {
    BaseWidgetComposable(widget) {
        Column {
            widget.components.forEach { component ->
                ComponentEngine(component, uiDelegate)
            }
        }
    }
}