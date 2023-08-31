package com.example.composesdui.ui.sdengine.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composesdui.api.model.component.SectionExpander
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.theme.Typography
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SectionExpanderComposable(
    component: SectionExpander,
    uiDelegate: UIDelegate,
    expandState: MutableState<Boolean>? = null
) {
    expandState?.let {
        val scope = rememberCoroutineScope()
        Row(
            modifier = Modifier.clickable {
                scope.launch {
                    it.value = !it.value
                }
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (it.value) component.data.collapseText else component.data.expandText,
                style = Typography.labelLarge
            )
            GlideImage(
                modifier = Modifier.requiredSize(12.dp),
                model = if (it.value) component.data.collapseImageURL else component.data.expandImageURL,
                contentDescription = null
            )
        }
    }
}