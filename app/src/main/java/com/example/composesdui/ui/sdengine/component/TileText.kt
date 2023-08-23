package com.example.composesdui.ui.sdengine.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composesdui.api.model.component.TileTextComponent

@Composable
fun TileTextComposable(component: TileTextComponent) {
    Text(text = component.data.text)
}