package com.example.composesdui.ui.sdengine.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composesdui.api.model.component.BaseComponent
import com.example.composesdui.api.model.widget.GridMaxTwoExpandable
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.sdengine.ComponentEngine
import com.example.composesdui.ui.theme.Typography

@Composable
fun GridMaxTwoExpandableComposable(widget: GridMaxTwoExpandable, uiDelegate: UIDelegate) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row {
            Text(
                modifier = Modifier.fillMaxWidth(0.5f),
                text = widget.header?.title ?: "",
                style = Typography.titleLarge
            )
            Box(modifier = Modifier.fillMaxWidth(1f), contentAlignment = Alignment.CenterEnd) {
                widget.header?.components?.first()?.let { ComponentEngine(it, uiDelegate) }
            }
        }
        Spacer(modifier = Modifier.padding(1.dp))
        val expand = remember { mutableStateOf(true) }
        if (expand.value) {
            Content(widget.components, uiDelegate)
        } else {
            Content(widget.components.take(2), uiDelegate)
        }
    }
}

@Composable
private fun Content(components: List<BaseComponent>, uiDelegate: UIDelegate) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Gray)
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(components) { component ->
                ComponentEngine(component, uiDelegate)
            }
        }
    }
}