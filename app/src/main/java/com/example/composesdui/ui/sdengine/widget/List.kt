package com.example.composesdui.ui.sdengine.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composesdui.api.model.widget.ListWidget
import com.example.composesdui.ui.sdengine.ComponentEngine
import com.example.composesdui.ui.theme.Typography

@Composable
fun ListWidgetComposable(widget: ListWidget) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text( text = widget.header?.title ?: "", style = Typography.titleLarge)
        Spacer(modifier = Modifier.padding(1.dp))
        widget.components.forEach { component ->
            ComponentEngine(component)
        }
    }
}