package com.example.composesdui.ui.sdengine.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composesdui.api.model.component.TileImageComponent

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TileImageComposable(component: TileImageComponent) {
    GlideImage(
        modifier = Modifier.fillMaxWidth(1f),
        model = component.data.imageURL,
        contentDescription = "glide image"
    )
}