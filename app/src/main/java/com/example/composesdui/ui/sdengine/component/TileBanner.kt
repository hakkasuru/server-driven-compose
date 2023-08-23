package com.example.composesdui.ui.sdengine.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composesdui.api.model.component.TileBannerComponent

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TileBannerComposable(component: TileBannerComponent) {
    Card(modifier = Modifier.padding(4.dp)) {
        GlideImage(
            modifier = Modifier.requiredWidth(300.dp),
            model = component.data.imageURL,
            contentDescription = "glide image"
        )
    }
}

@Preview(device = Devices.PIXEL_3A_XL)
@Composable
private fun PreviewTileBanner() {
    TileBannerComposable(TileBannerComponent.mockComponent("https://picsum.photos/1920/500"))
}