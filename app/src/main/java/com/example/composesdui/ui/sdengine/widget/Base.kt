package com.example.composesdui.ui.sdengine.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composesdui.api.model.widget.BaseWidget
import com.example.composesdui.ui.theme.Typography

@Composable
fun BaseWidgetComposable(widget: BaseWidget, content: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text( text = widget.header?.title ?: "", style = Typography.titleLarge)
        Spacer(modifier = Modifier.padding(1.dp))
        content()
    }
}