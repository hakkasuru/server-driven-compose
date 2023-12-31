package com.example.composesdui.ui.sdengine.widget

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.composesdui.api.model.widget.CarouselWidget
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.sdengine.ComponentEngine

@Composable
fun CarouselWidgetComposable(widget: CarouselWidget, uiDelegate: UIDelegate) {
    BaseWidgetComposable(widget) {
        LazyRow {
            items(widget.components) { component ->
                ComponentEngine(component, uiDelegate)
            }
        }
    }
}