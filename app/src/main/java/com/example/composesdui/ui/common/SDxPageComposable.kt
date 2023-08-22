package com.example.composesdui.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composesdui.api.model.SDPage
import com.example.composesdui.ui.sdengine.WidgetEngine

@Composable
fun CommonPageComposable(page: SDPage) {
    Surface {
        LazyColumn {
            itemsIndexed(page.widgets) { index, widget ->
                WidgetEngine(widget)
            }
        }
    }
}