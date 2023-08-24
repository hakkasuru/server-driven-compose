package com.example.composesdui.ui.sdengine

import androidx.compose.runtime.Composable
import com.example.composesdui.api.model.component.BaseComponent
import com.example.composesdui.api.model.component.TileBannerComponent
import com.example.composesdui.api.model.component.TileImageComponent
import com.example.composesdui.api.model.component.TileTextComponent
import com.example.composesdui.api.model.widget.BaseWidget
import com.example.composesdui.api.model.widget.CarouselWidget
import com.example.composesdui.api.model.widget.ListWidget
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.sdengine.component.TileBannerComposable
import com.example.composesdui.ui.sdengine.component.TileImageComposable
import com.example.composesdui.ui.sdengine.component.TileTextComposable
import com.example.composesdui.ui.sdengine.widget.CarouselWidgetComposable
import com.example.composesdui.ui.sdengine.widget.ListWidgetComposable

@Composable
fun WidgetEngine(widget: BaseWidget, uiDelegate: UIDelegate) {
    when (widget) {
        is ListWidget -> ListWidgetComposable(widget, uiDelegate)
        is CarouselWidget -> CarouselWidgetComposable(widget, uiDelegate)
        else -> {}
    }
}

@Composable
fun ComponentEngine(component: BaseComponent, uiDelegate: UIDelegate) {
    when (component) {
        is TileTextComponent -> TileTextComposable(component, uiDelegate)
        is TileImageComponent -> TileImageComposable(component, uiDelegate)
        is TileBannerComponent -> TileBannerComposable(component, uiDelegate)
        else -> {}
    }
}