package com.example.composesdui.ui.sdengine.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composesdui.api.model.component.TileCard
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.ui.theme.Typography
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TileCardComposable(component: TileCard, uiDelegate: UIDelegate) {
    val scope = rememberCoroutineScope()
    Card(
        modifier = Modifier
            .padding(4.dp)
            .requiredHeight(104.dp)
            .clickable {
                scope.launch {
                    component.action?.let {
                        uiDelegate.onClick(it)
                    }
                }
            }
    ) {
        Row {
            GlideImage(
                modifier = Modifier.fillMaxHeight(1f).fillMaxWidth(0.3f),
                model = component.data.imageURL,
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Column(modifier = Modifier.fillMaxWidth(0.7f).padding(2.dp)) {
                Text(
                    text = component.data.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.titleMedium
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    text = component.data.description,
                    maxLines = 4,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.labelSmall
                )
            }
        }
    }
}