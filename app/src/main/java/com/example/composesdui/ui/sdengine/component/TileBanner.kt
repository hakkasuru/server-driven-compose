package com.example.composesdui.ui.sdengine.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composesdui.api.model.component.TileBannerComponent
import com.example.composesdui.core.delegate.ui.UIDelegate
import com.example.composesdui.core.delegate.ui.UIDelegateNoop
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TileBannerComposable(component: TileBannerComponent, uiDelegate: UIDelegate) {
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = Modifier.padding(4.dp)
            .clickable {
                component.action?.let { action ->
                    coroutineScope.launch {
                        Log.d("TileBannerComposable", "on action clicked")
                        uiDelegate.onClick(action)
                    }
                }
            }
    ) {
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
    TileBannerComposable(
        TileBannerComponent.mockComponent("https://picsum.photos/1920/500"),
        UIDelegateNoop()
    )
}