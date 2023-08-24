package com.example.composesdui.ui.sdengine.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composesdui.api.model.widget.ListWidget
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.sdengine.ComponentEngine
import com.example.composesdui.ui.theme.Typography

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