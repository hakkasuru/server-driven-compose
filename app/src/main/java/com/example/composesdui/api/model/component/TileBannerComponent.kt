package com.example.composesdui.api.model.component

data class TileBannerComponent(val data: Data) : BaseComponent() {
    data class Data(
        val imageURL: String = ""
    )

    companion object {
        fun mockComponent(imageURL: String = ""): TileBannerComponent {
            val comp = TileBannerComponent(Data(imageURL = imageURL))
            comp.type = "tile-image"
            return comp
        }
    }
}