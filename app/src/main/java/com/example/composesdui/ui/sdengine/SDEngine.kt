package com.example.composesdui.ui.sdengine

import androidx.compose.runtime.Composable
import com.example.composesdui.api.model.component.BaseComponent
import com.example.composesdui.api.model.component.TileImageComponent
import com.example.composesdui.api.model.component.TileTextComponent
import com.example.composesdui.api.model.widget.BaseWidget
import com.example.composesdui.api.model.widget.CarouselWidget
import com.example.composesdui.api.model.widget.ListWidget
import com.example.composesdui.ui.sdengine.component.TileImageComposable
import com.example.composesdui.ui.sdengine.component.TileTextComposable
import com.example.composesdui.ui.sdengine.widget.CarouselWidgetComposable
import com.example.composesdui.ui.sdengine.widget.ListWidgetComposable

@Composable
fun WidgetEngine(widget: BaseWidget) {
    when (widget) {
        is ListWidget -> ListWidgetComposable(widget)
        is CarouselWidget -> CarouselWidgetComposable(widget)
        else -> {}
    }
}

@Composable
fun ComponentEngine(component: BaseComponent) {
    when (component) {
        is TileTextComponent -> TileTextComposable(component)
        is TileImageComponent -> TileImageComposable(component)
        else -> {}
    }
}