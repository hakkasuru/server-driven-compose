package com.example.composesdui.ui.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.composesdui.api.model.SDPage
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.sdengine.WidgetEngine
import kotlinx.coroutines.flow.collect

@Composable
fun CommonPageComposable(page: SDPage, uiDelegate: UIDelegate) {
    Surface {
        LazyColumn {
            items(page.widgets) { widget ->
                WidgetEngine(widget, uiDelegate)
            }
        }
    }
}