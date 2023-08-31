package com.example.composesdui.ui.sdengine.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.composesdui.ui.common.VerticalGrid
import com.example.composesdui.ui.sdengine.ComponentEngine
import com.example.composesdui.ui.theme.Typography

@Composable
fun GridMaxTwoExpandableComposable(widget: GridMaxTwoExpandable, uiDelegate: UIDelegate) {
    Column(modifier = Modifier.padding(8.dp)) {
        val expand = remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            val expandableComponent = widget.header?.components?.first()
            Text(
                modifier = Modifier.fillMaxWidth(expandableComponent?.let { 0.5f } ?: 1f),
                text = widget.header?.title ?: "",
                style = Typography.titleLarge
            )
            expandableComponent?.let {
                Box(
                    modifier = Modifier.fillMaxWidth(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    ComponentEngine(it, uiDelegate, expand)
                }
            }
        }
        Spacer(modifier = Modifier.padding(1.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Gray)
        ) {
            if (widget.components.isEmpty()) return@Card
            VerticalGrid(columns = 2) {
                widget.components.take(2).forEach {
                    ComponentEngine(it, uiDelegate)
                }
            }
            if (widget.components.size <= 2) return@Card
            AnimatedVisibility(
                visible = expand.value,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                VerticalGrid(columns = 2) {
                    widget.components.takeLast(widget.components.size-2).forEach {
                        ComponentEngine(it, uiDelegate)
                    }
                }
            }
        }
    }
}