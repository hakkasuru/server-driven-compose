package com.example.composesdui.ui.sdengine.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composesdui.api.model.component.TileTextComponent
import com.example.composesdui.ui.theme.Typography

@Composable
fun TileTextComposable(component: TileTextComponent) {
    Column {
        Text(text = component.data.title, style = Typography.titleSmall)
        Text(text = component.data.subtitle)
    }
}